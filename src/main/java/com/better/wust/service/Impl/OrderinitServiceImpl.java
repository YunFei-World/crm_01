package com.better.wust.service.Impl;

import com.better.wust.dao.OrderinitDao;
import com.better.wust.dao.SaleDao;
import com.better.wust.dao.TransRecordDao;
import com.better.wust.entity.*;
import com.better.wust.service.OrderinitService;
import com.better.wust.service.SaleService;
import com.better.wust.tools.DateUtils;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderinitServiceImpl implements OrderinitService {

    @Autowired
    private OrderinitDao orderinitDao;
    @Autowired
    private TransRecordDao transRecordDao;



    @Override
    public String getMarketingIdByChannelAndMarketingName(String marketing_name, String channel_id) {
        return orderinitDao.getMarketingIdByChannelAndMarketingName(marketing_name,channel_id);
    }

    @Override
    public List<Orderinit> findAllOrder(SelectEntity selectEntity) throws RuntimeException {
        return orderinitDao.selectAllOrder(selectEntity);
    }

    @Override
    public int findOrderNum(SelectEntity selectEntity) throws RuntimeException {
        return orderinitDao.selectOrderNum(selectEntity);
    }

    @Override
    public void modifyOrderinitByMark(Orderinit orderinit) throws RuntimeException {
        orderinitDao.updateOrderinitByMark(orderinit);
    }

    @Override
    public String modifyOrderinitByEffecitve(Orderinit orderinit) throws RuntimeException {
        String sale_id = getSaleLastId();

        if (sale_id == null) {
            sale_id = "sale-1000";
        } else {
            sale_id = "sale-" + (Integer.parseInt(sale_id.split("-")[1]) + 1);
        }
        orderinit.setTel_time(new Date());

        if(orderinitDao.selectOrderNumByInitId(orderinit.getOrder_init_id())==0){
            //修改  如果数据库中已经有此毛单的后续数据了  不能再更改其属性
            orderinitDao.updateOrderinitByEffecitve(orderinit);
        }else{//如"接通-意愿到店"和”接通-待定“都会生成对应后部数据  返回已经有此数据存在
            return "havingsale";
        }

        //查询sale表中是否已经存在该orderinit所对应的数据，有则不生成新的sale   没有则生成新的sale

        if(orderinitDao.selectOrderNumByInitId(orderinit.getOrder_init_id())==0){
            if("a.接通-有意到店".equals(orderinit.getEffective())||"b.接通-待定".equals(orderinit.getEffective())) {
                if ("未加入微信群".equals(orderinit.getWeixin())){
                    addSale(sale_id, orderinit.getOrder_init_id());
                    return sale_id;
                }else{
                    return "havingweixin";
                }
            }else{
                return "nohaving";
            }
        }else{
            return "havingsale";
        }





    }

    @Override
    public void modifyOrderinitByAdmin(Orderinit orderinit) throws RuntimeException {
        orderinitDao.updateOrderinitByAdmin(orderinit);
    }

    @Override
    public void assignOrders(String id, String staff_id) throws RuntimeException {
        orderinitDao.assignOrders(id, staff_id, new Date());
    }



    @Override
    public String checkedOrderState(String id) throws RuntimeException {
        return orderinitDao.checkedOrderState(id);
    }

    @Override
    public void addSale(String sale_id, String order_init_id) throws RuntimeException {
        String time_load;
        time_load=DateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
        orderinitDao.insertSale(sale_id, order_init_id,time_load);
    }

    @Override
    public String getSaleLastId() throws RuntimeException {
        return orderinitDao.selectSaleLastId();
    }

    @Override
    public int addOrderinit(Orderinit orderinit) throws RuntimeException {
        //判断毛单库中没有与这个毛单重复的毛单  没有则加入毛单库 否则去除
        int exist=orderinitDao.isExistOrderinit(orderinit.getCustomer_name(),orderinit.getCustomer_contact());

        if (exist==0){
            String order_init_id = getOrderinitLastId();
            if (order_init_id == null) {
                order_init_id = "init-1000";
            } else {
                order_init_id = "init-" + (Integer.parseInt(order_init_id.split("-")[1]) + 1);
            }
            orderinit.setEntry_real(new Date());
            orderinit.setOrder_init_id(order_init_id);
            orderinitDao.insertOrderinit(orderinit);
            return 1;
        }else{
            return 0;
        }


    }

    @Override
    public String getOrderinitLastId() throws RuntimeException {
        return orderinitDao.selectOrderinitLastId();
    }

    @Override
    public List<Orderinit> findAllOrderById(SelectEntity selectEntity) throws RuntimeException {
        return orderinitDao.selectAllOrderById(selectEntity);
    }

    @Override
    public int findOrderNumById(SelectEntity selectEntity) throws RuntimeException {
        return orderinitDao.selectOrderNumById(selectEntity);
    }

    @Override
    public List<Orderinit> findAllOrderByAssginId(SelectEntity selectEntity) throws RuntimeException {
        return orderinitDao.selectOrderByAssginId(selectEntity);
    }

    @Override
    public int findOrderNumByAssginId(SelectEntity selectEntity) throws RuntimeException {
        return orderinitDao.selectOrderNumByAssginId(selectEntity);
    }

    @Override
    public String getIdByType(String channel_type) {
        return orderinitDao.selectIdByType(channel_type);
    }

    @Override
    public int selectOrderNumByInitId(String order_init_id) {
        return orderinitDao.selectOrderNumByInitId(order_init_id);
    }


    //销售单  初始单 转换


    @Override
    public void transformOrders(TransRecord transRecord) throws RuntimeException {
        transRecord.setTrans_time(new Date());
        String id = orderinitDao.selectStaffIdById(transRecord.getOrder_init_id());
        transRecord.setOut_staff_id(id);
        transRecordDao.insertTransRecord(transRecord);//初始单转换记录
        orderinitDao.transformOrders(transRecord.getOrder_init_id(), transRecord.getStaff_id());
    }


    @Override
    public void transformSales(TransRecord transRecord)throws RuntimeException  {
        transRecord.setTrans_time(new Date());
        String id = orderinitDao.selectStaffIdById(transRecord.getOrder_init_id());
        transRecord.setOut_staff_id(id);
        transRecordDao.insertTransRecordSecond(transRecord);//销售单转换记录
        orderinitDao.transformSales(transRecord.getOrder_init_id(), transRecord.getStaff_id());
    }


    @Override
    public List<Orderinit> findAllOrderinit(SelectEntity selectEntity) {
        return orderinitDao.findAllOrderinit(selectEntity);
    }

    @Override
    public int getAllOrderinitNumber(SelectEntity selectEntity) {
        return orderinitDao.getAllOrderinitNum(selectEntity);
    }


    @Override
    public Sale findSaleByOrderinit(String order_init_id) {
        return orderinitDao.findSaleByOrderinit(order_init_id);
    }


    @Override
    public List<ChanStatistics> findAllMyOrderInitStatisticsList(SelectEntity selectEntity) {
        return orderinitDao.findAllMyOrderInitStatisticsList(selectEntity);
    }

    @Override
    public int getAllMyOrderInitStatisticsNumber(SelectEntity selectEntity) {
        return orderinitDao.getAllMyOrderInitStatisticsNumber(selectEntity);
    }

    @Override
    public void updateStatisticsByTime(String time_start, String time_end,String staff_id) {

        time_end=time_end+" 23:59:59";

        int state_num_one = orderinitDao.statisticsOrderinitStateOneByTime(time_start,time_end,staff_id);
        int state_num_two = orderinitDao.statisticsOrderinitStateTwoByTime(time_start,time_end,staff_id);
        int state_num_three = orderinitDao.statisticsOrderinitStateThreeByTime(time_start,time_end,staff_id);
        int state_num_four = orderinitDao.statisticsOrderinitStateFourByTime(time_start,time_end,staff_id);

        int sum_num = orderinitDao.statisticsOrderinitSumnumByTime(time_start,time_end,staff_id);
        double state_proportion_one;
        double state_proportion_two;
        double state_proportion_three;
        double state_proportion_four;

        if (sum_num!=0){
            state_proportion_one=(double) state_num_one/sum_num;
            state_proportion_two=(double) state_num_two/sum_num;
            state_proportion_three=(double) state_num_three/sum_num;
            state_proportion_four=(double) state_num_four/sum_num;
        }else {
            state_proportion_one=0;
            state_proportion_two=0;
            state_proportion_three=0;
            state_proportion_four=0;
        }

        OrderInitStatistics orderInitStatistics=new OrderInitStatistics();
        orderInitStatistics.setStaff_id(staff_id);
        orderInitStatistics.setTime_start(time_start);
        orderInitStatistics.setTime_end(time_end);

        orderInitStatistics.setSum_num(sum_num);

        orderInitStatistics.setOrderinit_state_one("a.接通-有意到店");
        orderInitStatistics.setOrderinit_state_two("b.接通-待定");
        orderInitStatistics.setOrderinit_state_three("c.接通-拒绝");
        orderInitStatistics.setOrderinit_state_four("d.未接通");

        orderInitStatistics.setState_num_one(state_num_one);
        orderInitStatistics.setState_num_two(state_num_two);
        orderInitStatistics.setState_num_three(state_num_three);
        orderInitStatistics.setState_num_four(state_num_four);

        orderInitStatistics.setState_proportion_one(state_proportion_one);
        orderInitStatistics.setState_proportion_two(state_proportion_two);
        orderInitStatistics.setState_proportion_three(state_proportion_three);
        orderInitStatistics.setState_proportion_four(state_proportion_four);


        OrderInitStatistics isExit=orderinitDao.orderStatisticIsExit(staff_id);

        if (isExit!=null){
            orderinitDao.updateStatisticsByTime(orderInitStatistics);
        }else{
            orderinitDao.insertOrderInitStatistics(orderInitStatistics);
        }


    }
}
