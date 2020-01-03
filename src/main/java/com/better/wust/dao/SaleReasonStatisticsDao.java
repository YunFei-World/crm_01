package com.better.wust.dao;

import com.better.wust.entity.SaleReasonStatistics;

import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleReasonStatisticsDao {


    public int statisticsSaleReasonNumByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")String false_reason, @Param("param4")String sale_stage,@Param("param5")String campus_id);

    public int statisticsSaleReasonSumNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String sale_stage,@Param("param4")String campus_id);

    public void updateStatisticsByTime(SaleReasonStatistics saleReasonStatistics);

    public List<SaleReasonStatistics> findAllSaleReasonStatistics(@Param("param1")String campus_id);

    public List<SaleReasonStatistics> findAllSaleReasonStatisticsList(SelectEntity selectEntity);

    public int getAllSaleReasonStatisticsNumber(SelectEntity selectEntity);
}
