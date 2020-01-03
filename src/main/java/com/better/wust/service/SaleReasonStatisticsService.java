package com.better.wust.service;

import com.better.wust.entity.SaleReasonStatistics;
import com.better.wust.tools.entity.SelectEntity;


import java.util.List;

public interface SaleReasonStatisticsService {

    //my
    public List<SaleReasonStatistics> findAllSaleReasonStatistics(String campus_id,String sale_stage);

    public List<SaleReasonStatistics> findAllSaleReasonStatisticsList(SelectEntity selectEntity);

    public int getAllSaleReasonStatisticsNumber(SelectEntity selectEntity);


    public void updateStatisticsByTime(String time_start,String time_end,String campus_id,String sale_stage);



}
