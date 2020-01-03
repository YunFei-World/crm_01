package com.better.wust.dao;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.SaleStatistics;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleStatisticsDao {

    public List<SaleStatistics> selectSaleStatistics(SelectEntity selectEntity);

    public int selectSaleStatisticsNumber(SelectEntity selectEntity);

    public List<SaleStatistics> statisticsSaleMonth(@Param("month") String month,@Param("staff_id") String staff_id,@Param("campus_id") String campus_id);

    public SaleStatistics statisticsIsExist(SaleStatistics saleStatistics);

    public void updateStatisticsBySaleAndMonth(SaleStatistics saleStatistics);

    public void insertStatistics(SaleStatistics saleStatistics);


    //my
   // public void insertNewStage(String campus_id);

    public int statisticsSaleStageNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String sale_stage,@Param("param4")String campus_id);

    public int statisticsSaleStageSumNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String campus_id);

    public void updateStatisticsByTime(SaleStatistics saleStatistics);

    public List<SaleStatistics>  findAllSaleStageStatistics(@Param("param1")String  campus_id);

    public List<SaleStatistics>  findAllSaleStageStatisticsList(SelectEntity selectEntity);

    public int getAllSaleStatisticsNumber(SelectEntity selectEntity);

}
