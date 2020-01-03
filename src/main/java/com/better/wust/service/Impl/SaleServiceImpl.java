package com.better.wust.service.Impl;

import com.better.wust.dao.OrderinitDao;
import com.better.wust.dao.SaleDao;
import com.better.wust.dao.SignDao;
import com.better.wust.entity.*;
import com.better.wust.service.SaleService;
import com.better.wust.tools.DateUtils;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;

    @Autowired
    private SignDao signDao;

    @Autowired
    private OrderinitDao orderinitDao;



    @Override
    public List<StudentClass> findAllStudentUpdateCampus(SelectEntity selectEntity) {
        return saleDao.findAllStudentUpdateCampus(selectEntity);
    }

    @Override
    public int getAllStudentUpdateCampusNumber(SelectEntity selectEntity) {
        return saleDao.getAllStudentUpdateCampusNumber(selectEntity);
    }

    @Override
    public double getStudentAllRealBalance(int student_id) {
        return saleDao.getStudentAllRealBalance(student_id);
    }


    @Override
    public Student findStudentById(int student_id) {
        return saleDao.findStudentById(student_id);
    }

    @Override
    public void finishStudentUpdateCampus(int student_id) {


        //3.更新学生课程表单  is_retire=4 表示学生已经更换校区完成 （查询所有表中对应该学生的所有学生课程项(将状态为2的 都变为4） ）
        saleDao.finishStudentUpdateCampus(student_id);


    }

    @Override
    public List<StudentClass> findAllStudentRefund(SelectEntity selectEntity) {
        return saleDao.findAllStudentRefund(selectEntity);
    }

    @Override
    public int getAllStudentRefundNumber(SelectEntity selectEntity) {
        return saleDao.getAllStudentRefundNumber(selectEntity);
    }

    @Override
    public void finishStudentRefund(int id,int student_id,int course_id) {

        Student student=saleDao.findStudentById(student_id);
        String course=student.getCourse_id();

        String[] ids=course.split("\\|");


        String new_course_id="";
        List<String> courselist=new ArrayList<>();


        for (String courseid:ids){
            if (courseid.equals(course_id+"")){

            }else{
                courselist.add(courseid);
            }
        }

        int list_length=courselist.size();


        if (list_length==0){
            new_course_id="";
        }else if (list_length==1){
            new_course_id=courselist.get(0);
        }else{
            new_course_id=courselist.get(0);
            for (int i=1;i<list_length;i++){
                new_course_id=new_course_id+"|"+courselist.get(i);
            }
        }

        //学生退课，清除学生表中的课程信息
        saleDao.cleanStudentRefundCourse(student.getStudent_id(),new_course_id);




        //学生退课，清除学生课程表中的信息
        saleDao.finishStudentRefund(id);
    }







    public void addInitAndSaleByComeToShop(Orderinit orderinit) {
        String order_init_id = orderinitDao.selectOrderinitLastId();
        if (order_init_id == null) {
            order_init_id = "init-1000";
        } else {
            order_init_id = "init-" + (Integer.parseInt(order_init_id.split("-")[1]) + 1);
        }


        String sale_id = orderinitDao.selectSaleLastId();
        if (sale_id == null) {
            sale_id = "sale-1000";
        } else {
            sale_id = "sale-" + (Integer.parseInt(sale_id.split("-")[1]) + 1);
        }

        orderinit.setEntry_real(new Date());
        orderinit.setOrder_init_id(order_init_id);

        orderinit.setTel_time(new Date());
        orderinit.setEffective("有效单");
        orderinit.setWeixin("待定");
        orderinitDao.insertOrderinit(orderinit);


        orderinitDao.assignOrders(order_init_id, orderinit.getOrder_staff_id(), new Date());


        String time_load;
        time_load= DateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
        orderinitDao.insertSale(sale_id, order_init_id,time_load);

    }

    @Override
    public List<Sale> findAllSales(SelectEntity selectEntity) throws RuntimeException {
        return saleDao.selectAllSales(selectEntity);
    }

    @Override
    public int getSaleNumber(SelectEntity selectEntity) throws RuntimeException {
        return saleDao.selectSaleNumber(selectEntity);
    }

    @Override
    public int modifySale(Sale sale) throws RuntimeException {
        int getsign=0;
        sale.setIs_coming("未上访");


        //查看sale中原因是否为F.其它因素  如果不是F 则将other_reason为""
        if (sale.getFalse_reason().equals("F.其它因素")){

        }else{
            sale.setOther_reason("");
        }


        saleDao.updateSale(sale);
        saleDao.updateOrderinitChannelStaff(sale);
        if (signDao.selectSignNumById(sale.getSale_id())==0){
            if("B-接受".equals(sale.getSale_stage()) ){
                String sign_id = signDao.selectLastSign();
                if (sign_id == null) {
                    sign_id = "sign-1000";
                } else {
                    sign_id = "sign-" + (Integer.parseInt(sign_id.split("-")[1]) + 1);
                }
                signDao.insertSign(sign_id,sale.getSale_id());
                getsign=1;
            }
        }
        return getsign;
    }

    @Override
    public String addFollow(FollowUp followUp) throws RuntimeException {
        Date date = new Date();
        String follow_up_id = findLastFollow();
        if (follow_up_id == null) {
            follow_up_id = "1000000";
        } else {
            follow_up_id = "" + (Integer.parseInt(follow_up_id) + 1);
        }
        followUp.setTime_load(date);
        followUp.setFollow_up_id(follow_up_id);
        //在更新sale表单之前  先要判断这个客户是否已经到店过  不能根据这次回访记录是电话回访而更新其没有到店过
        //如果没有到访过，从此回访记录登记的其方式均为未上访
        Sale sale=saleDao.selectSaleById(followUp.getSale_id());


        if (sale.getIs_coming().equals("上访")){
            followUp.setIs_coming("上访");
        }else {
            followUp.setIs_coming("未上访");
        }


        saleDao.insertFollow(followUp);

        //更新回访表中  有效 无效??????待考究
        //同一销售单的回访记录 有效  无效  保持一致  更新则全部更新--保证最后统计时  可以统计出回访有效数量
        saleDao.updateFollow(followUp);

        saleDao.updateSaleByFollow(followUp.getNext_time_up(), followUp.getJudge_up(),
                followUp.getSale_stage_up(), followUp.getSale_id(),followUp.getFalse_reason(),followUp.getIs_coming(),followUp.getArrive_time(),followUp.getOther_reason());

        if (signDao.selectSignNumById(followUp.getSale_id())==0){
            if("B-接受".equals(followUp.getSale_stage_up()) ){
                String sign_id = signDao.selectLastSign();
                if (sign_id == null) {
                    sign_id = "sign-1000";
                } else {
                    sign_id = "sign-" + (Integer.parseInt(sign_id.split("-")[1]) + 1);
                }
                signDao.insertSign(sign_id,followUp.getSale_id());
            }
        }
        return follow_up_id;
    }

    @Override
    public String addComeToShopFollow(FollowUp followUp) {
        Date date = new Date();
        String follow_up_id = findLastFollow();
        if (follow_up_id == null) {
            follow_up_id = "1000000";
        } else {
            follow_up_id = "" + (Integer.parseInt(follow_up_id) + 1);
        }
        followUp.setTime_load(date);
        followUp.setFollow_up_id(follow_up_id);

        //此为到店添加的记录则设置其到店为 上访

        followUp.setIs_coming("上访");

        saleDao.insertFollow(followUp);
        //更新回访表中  有效 无效
        //同一销售单的回访记录 有效  无效  保持一致  更新则全部更新--保证最后统计时  可以统计出回访有效数量
        saleDao.updateFollow(followUp);



        //如果这次访问未下单   还可以接着填写下次到店时间   如果不写  则arrive_time 变未null  此sale信息不会出现在邀约客户列表中

        saleDao.updateSaleByFollow(followUp.getNext_time_up(), followUp.getJudge_up(),
                followUp.getSale_stage_up(), followUp.getSale_id(),followUp.getFalse_reason(),followUp.getIs_coming(),followUp.getArrive_time(),followUp.getOther_reason());

        if (signDao.selectSignNumById(followUp.getSale_id())==0){
            if("B-接受".equals(followUp.getSale_stage_up()) ){
                String sign_id = signDao.selectLastSign();
                if (sign_id == null) {
                    sign_id = "sign-1000";
                } else {
                    sign_id = "sign-" + (Integer.parseInt(sign_id.split("-")[1]) + 1);
                }
                signDao.insertSign(sign_id,followUp.getSale_id());
            }
        }
        return follow_up_id;
    }

    @Override
    public List<FollowUp> findAllFollow(SelectEntity selectEntity) throws RuntimeException {
        return saleDao.selectAllFollows(selectEntity);
    }

    @Override
    public int getFollowNumber(SelectEntity selectEntity) {
        return saleDao.selectFollowNumber(selectEntity);
    }

    @Override
    public List<Sale> findAllSalesById(SelectEntity selectEntity) {
        return saleDao.selectAllSalesById(selectEntity);
    }

    @Override
    public int getSaleNumberById(SelectEntity selectEntity) {
        return saleDao.selectSaleNumberById(selectEntity);
    }




    @Override
    public List<Sale> findAllComeToShopSaleById(SelectEntity selectEntity) {
        return saleDao.findAllComeToShopSaleById(selectEntity);
    }

    @Override
    public int getAllComeToShopSaleNumberById(SelectEntity selectEntity) {
        return saleDao.getAllComeToShopSaleNumberById(selectEntity);
    }

    @Override
    public List<Sale> findNotComeToShopSaleById(SelectEntity selectEntity) {
        return saleDao.findNotComeToShopSaleById(selectEntity);
    }

    @Override
    public int getNotComeToShopSaleNumberById(SelectEntity selectEntity) {
        return saleDao.getNotComeToShopSaleNumberById(selectEntity);
    }

    @Override
    public List<Sale> findHaveComeToShopSaleById(SelectEntity selectEntity) {
        return saleDao.findHaveComeToShopSaleById(selectEntity);
    }

    @Override
    public int getHaveComeToShopSaleNumberById(SelectEntity selectEntity) {
        return saleDao.getHaveComeToShopSaleNumberById(selectEntity);
    }


    @Override
    public List<Sale> findHaveComeToShopSaleUnSignById(SelectEntity selectEntity) {
        return saleDao.findHaveComeToShopSaleUnSignById(selectEntity);
    }

    @Override
    public int getHaveComeToShopSaleUnSignNumberById(SelectEntity selectEntity) {
        return saleDao.getHaveComeToShopSaleUnSignNumberById(selectEntity);
    }

    @Override
    public Sale findSaleById(String sale_id) {
        return saleDao.selectSaleById(sale_id);
    }

    @Override
    public FollowUp findLastFollowById(FollowUp followUp) {
        FollowUp fp = saleDao.selectLastFollowById(followUp);
        if (fp == null){
            return followUp;
        }
        return fp;
    }

    public String findLastFollow() {
        return saleDao.selectLastFollow();
    }

    @Override
    public void modifyScreen_Image(FollowUp followUp) throws RuntimeException {
        saleDao.updateScreen_Image(followUp);
    }


    @Override
    public void cleanStudentCourse(String student_id) {
        saleDao.cleanStudentCourse(student_id);
    }

    @Override
    public void updateStudentByUpdateCampus(Student student) {
        saleDao.updateStudentByUpdateCampus(student);
    }
}
