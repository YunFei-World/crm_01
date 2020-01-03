package com.better.wust.dao;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffStatisticsDao {



    public SaleTask statisticsTaskMonth(@Param("month") String month, @Param("Staff_id")String Staff_id,
                                        @Param("start1") String start1, @Param("end1")String end1,
                                        @Param("start2") String start2, @Param("end2")String end2,
                                        @Param("start3") String start3, @Param("end3")String end3,
                                        @Param("start4") String start4, @Param("end4")String end4,
                                        @Param("start5") String start5, @Param("end5")String end5,
                                        @Param("start6") String start6, @Param("end6")String end6);

    public void updateTaskMonth(SaleTask saleTask);

    public List<SaleTask> getStatisticsTaskMonth(SelectEntity selectEntity);

    public int getStatisticsTaskMonthNumber(SelectEntity selectEntity);


    //my

    // 月-周统计

    public int statisticsSumNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsTelNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsEffectiveNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsFollowUpEffectiveNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsDirectShopNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsBroughtShopNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsInvitationShopNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsActualShopNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);

    public int statisticsSignUpNumByMonth(@Param("param1")String month,@Param("param2")String assign_staff_id);




    public StaffStatisticsMonth statisticsMonthIsExist(@Param("param1") String month,  @Param("param2")String Staff_id);

    public void insertStaffStatisticsMonth(StaffStatisticsMonth staffStatisticsMonth);

    public void updateStatisticsByMonth(StaffStatisticsMonth staffStatisticsMonth);

    public List<StaffStatisticsMonth> selectStaffStatisticsMonth(SelectEntity selectEntity);

    public int selectStaffStatisticsMonthNumber(SelectEntity selectEntity);



    public Double statisticsSaleMoneyByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String  assign_staff_id);

    public Double statisticsSaleMoneyByMonth(@Param("param1")String month,@Param("param2")String  assign_staff_id);

    public SaleTask findSaleTaskByMonth(@Param("param1")String month,@Param("param2")String  staff_id);

    //月-周统计  end



    //时间段

    public int statisticsSumNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsTelNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsEffectiveNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsFollowUpEffectiveNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsDirectShopNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsBroughtShopNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsInvitationShopNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsActualShopNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);

    public int statisticsSignUpNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String assign_staff_id);







    public StaffStatisticsTime statisticsTimeIsExist(@Param("param1")String staff_id, @Param("param2")Integer campus_id);

    public void insertStatisticByTime(StaffStatisticsTime staffStatisticsTime);

    public void updateStatisticsByTime(StaffStatisticsTime staffStatisticsTime);

    public List<StaffStatisticsTime> findAllStaffTimeStatisticsList(SelectEntity selectEntity);

    public int getAllStaffTimeStatisticsNumber(SelectEntity selectEntity);



    //时间段 end



}
