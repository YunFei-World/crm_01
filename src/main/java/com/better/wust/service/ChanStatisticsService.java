package com.better.wust.service;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChanStatisticsService {

   /* public List<ChanStatistics> getChanStatistics(SelectEntity selectEntity);

    public int getChanStatisticsNumber(SelectEntity selectEntity);

    public void statisticsMonth(String month,String staff_id, String campus_id);*/



    //my

    public List<ChanStatistics>  findAllChanStatisticsList(SelectEntity selectEntity);

    public int  getAllChanStatisticsNumber(SelectEntity selectEntity);

    public void updateStatisticsByTime(String time_start,String time_end);
}
