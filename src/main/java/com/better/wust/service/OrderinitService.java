package com.better.wust.service;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Orderinit;
import com.better.wust.entity.Sale;
import com.better.wust.entity.TransRecord;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface OrderinitService {
    public List<Orderinit> findAllOrder(SelectEntity selectEntity);

    public int findOrderNum(SelectEntity selectEntity);

    public void modifyOrderinitByMark(Orderinit orderinit);

    //返回值 0 表示没有新增sale  1 表示新增sale
    public String modifyOrderinitByEffecitve(Orderinit orderinit);

    public void modifyOrderinitByAdmin(Orderinit orderinit);

    public void assignOrders(String id,String staff_id);



    public String checkedOrderState(String id);

    public void addSale(String sale_id,String order_init_id);

    public String getSaleLastId();

    public int addOrderinit(Orderinit orderinit);

    public String getOrderinitLastId();

    public List<Orderinit> findAllOrderById(SelectEntity selectEntity);

    public int findOrderNumById(SelectEntity selectEntity);

    public String getIdByType(String channel_type);

    public String getMarketingIdByChannelAndMarketingName(String marketing_name,String channel_id);

    public List<Orderinit> findAllOrderByAssginId(SelectEntity selectEntity);

    public int findOrderNumByAssginId(SelectEntity selectEntity);

    public int selectOrderNumByInitId(String order_init_id);



    //销售单  初始单 转换

    public void transformSales(TransRecord transRecord);

    public void transformOrders(TransRecord transRecord);

    public List<Orderinit> findAllOrderinit(SelectEntity selectEntity);

    public int getAllOrderinitNumber(SelectEntity selectEntity);



    //营销中毛单后续跟踪


    public Sale findSaleByOrderinit(String order_init_id);

    //营销中我的统计
    public List<ChanStatistics> findAllMyOrderInitStatisticsList(SelectEntity selectEntity);

    public int getAllMyOrderInitStatisticsNumber(SelectEntity selectEntity);

    public void updateStatisticsByTime(String time_start, String time_end,String staff_id);
}
