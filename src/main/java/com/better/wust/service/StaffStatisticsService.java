package com.better.wust.service;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffStatisticsService {


    // 月-周统计

    public int statisticsStaffMonth(StaffStatisticsMonth staffStatisticsMonth);

    public List<StaffStatisticsMonth> getStatisticsStaffMonth(SelectEntity selectEntity);

    public int getStatisticsStaffMonthNumber(SelectEntity selectEntity);

    //月-周统计  end





    //my 时间段
    public void updateStatisticsByTime(String time_start,String time_end,String staff_id,String campus_id);

    public List<StaffStatisticsTime> findAllStaffTimeStatisticsList(SelectEntity selectEntity);

    public int getAllStaffTimeStatisticsNumber(SelectEntity selectEntity);
    //时间段  end
}
