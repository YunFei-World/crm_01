package com.better.wust.dao;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderinitDao {

    public List<Orderinit> selectAllOrder(SelectEntity selectEntity);

    public int selectOrderNum(SelectEntity selectEntity);

    public void updateOrderinitByMark(Orderinit orderinit);

    public void updateOrderinitByEffecitve(Orderinit orderinit);

    public void updateOrderinitByAdmin(Orderinit orderinit);

    public void assignOrders(@Param("id") String id, @Param("staff_id") String staff_id, @Param("assign_time") Date assign_time);


    public String checkedOrderState(String id);

    public void insertSale(@Param("sale_id") String sale_id, @Param("order_init_id") String order_init_id,@Param("time_load") String time_load);

    public String selectSaleLastId();

    public String selectOrderinitLastId();

    public void insertOrderinit(Orderinit orderinit);

    public List<Orderinit> selectAllOrderById(SelectEntity selectEntity);

    public int selectOrderNumById(SelectEntity selectEntity);

    public String selectStaffIdById(String id);

    public String selectIdByType(String channel_type);

    public String getMarketingIdByChannelAndMarketingName(@Param("param1") String marketing_name, @Param("param2")String channel_id);


    public List<Orderinit> selectOrderByAssginId(SelectEntity selectEntity);

    public int selectOrderNumByAssginId(SelectEntity selectEntity);

    public int selectOrderNumByInitId(String order_init_id);



    //销售  初始单转换

    public void transformOrders(@Param("param1") String id, @Param("param2") String staff_id);

    public void transformSales(@Param("param1") String id, @Param("param2") String staff_id);


    public List<Orderinit> findAllOrderinit(SelectEntity selectEntity);

    public int getAllOrderinitNum(SelectEntity selectEntity);



    //毛单跟踪

    public Sale findSaleByOrderinit(String order_init_id);



    //我的毛单统计

    public int statisticsOrderinitStateOneByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")String staff_id);

    public int statisticsOrderinitStateTwoByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")String staff_id);

    public int statisticsOrderinitStateThreeByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")String staff_id);

    public int statisticsOrderinitStateFourByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")String staff_id);

    public  int statisticsOrderinitSumnumByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")String staff_id);

    public OrderInitStatistics orderStatisticIsExit(String staff_id);

    public void updateStatisticsByTime(OrderInitStatistics orderInitStatistics);

    public void insertOrderInitStatistics(OrderInitStatistics orderInitStatistics);




    public List<ChanStatistics> findAllMyOrderInitStatisticsList(SelectEntity selectEntity);

    public int getAllMyOrderInitStatisticsNumber(SelectEntity selectEntity);

    public int isExistOrderinit(@Param("param1")String customer_name, @Param("param2")String customer_contact);
}
