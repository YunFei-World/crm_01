package com.better.wust.dao;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Channel;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChanStatisticsDao {

 /*   public List<ChanStatistics> selectChanStatistics(SelectEntity selectEntity);

    public int selectChanStatisticsNumber(SelectEntity selectEntity);

    public List<ChanStatistics> statisticsMonth(@Param("param1") String month, @Param("param2")String staff_id, @Param("param3")String campus_id);

    public ChanStatistics statisticsIsExist(ChanStatistics chanStatistics);

    public void updateStatisticsByChanAndMonth(ChanStatistics chanStatistics);

    public void insertStatistics(ChanStatistics chanStatistics);*/



    //my





    public List<ChanStatistics>  findAllChanStatisticsList(SelectEntity selectEntity);

    public int  getAllChanStatisticsNumber(SelectEntity selectEntity);

    public int statisticsChannelEffectiveByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String channel_id);

    public int statisticsChannelUnEffectiveByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String channel_id);

    public int statisticsChannelWaitByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String channel_id);

    public int statisticsChannelUnContectByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String channel_id);

    public int statisticsChannelUncallByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String channel_id);

    public int statisticsChannelSumnumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")String channel_id);




    public ChanStatistics chanStatisticIsExit(@Param("param1")String channel_id, @Param("param2")Integer campus_id);

    public void updateStatisticsByTime(ChanStatistics chanStatistics);

    public void insertChannelStatistics(ChanStatistics chanStatistic);


}
