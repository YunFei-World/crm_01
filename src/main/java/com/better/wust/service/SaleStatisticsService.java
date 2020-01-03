package com.better.wust.service;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.SaleStatistics;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface SaleStatisticsService {

    public List<SaleStatistics> getSaleStatistics(SelectEntity selectEntity);

    public int getSaleStatisticsNumber(SelectEntity selectEntity);

    public void statisticsSaleMonth(String month,String staff_id,String campus_id);


    //my
    public List<SaleStatistics> findAllSaleStageStatisticsList(SelectEntity selectEntity);

    public int getAllSaleStatisticsNumber(SelectEntity selectEntity);

    public void updateStatisticsByTime(String time_start,String time_end,String campus_id);



}
