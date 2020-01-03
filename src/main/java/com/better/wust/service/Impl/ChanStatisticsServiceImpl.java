package com.better.wust.service.Impl;

import com.better.wust.dao.ChanStatisticsDao;
import com.better.wust.dao.ChannelDao;
import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Channel;
import com.better.wust.service.ChanStatisticsService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChanStatisticsServiceImpl implements ChanStatisticsService {

    @Autowired
    private ChanStatisticsDao chanStatisticsDao;

    @Autowired
    private ChannelDao channelDao;



    @Override
    public List<ChanStatistics> findAllChanStatisticsList(SelectEntity selectEntity) {
        return chanStatisticsDao.findAllChanStatisticsList(selectEntity);
    }

    @Override
    public int getAllChanStatisticsNumber(SelectEntity selectEntity) {
        return chanStatisticsDao.getAllChanStatisticsNumber(selectEntity);
    }

    @Override
    public void updateStatisticsByTime(String time_start,String time_end) {
        List<Channel> list=channelDao.findChannels();
        time_end=time_end+" 23:59:59";
        for (Channel channel:list){
            int effectivecount = chanStatisticsDao.statisticsChannelEffectiveByTime(time_start,time_end,channel.getChannel_id());
            int waitcount = chanStatisticsDao.statisticsChannelWaitByTime(time_start,time_end,channel.getChannel_id());
            int uneffectivecount = chanStatisticsDao.statisticsChannelUnEffectiveByTime(time_start,time_end,channel.getChannel_id());
            int uncontect = chanStatisticsDao.statisticsChannelUnContectByTime(time_start,time_end,channel.getChannel_id());
            int uncallcount = chanStatisticsDao.statisticsChannelUncallByTime(time_start,time_end,channel.getChannel_id());

            int sumnumcount = chanStatisticsDao.statisticsChannelSumnumByTime(time_start,time_end,channel.getChannel_id());
            double one_proportion;
            double two_proportion;
            double three_proportion;
            double four_proportion;
            double five_proportion;
            if (sumnumcount!=0){
                one_proportion=(double) effectivecount/sumnumcount;
                two_proportion=(double) waitcount/sumnumcount;
                three_proportion=(double) uneffectivecount/sumnumcount;
                four_proportion=(double) uncontect/sumnumcount;
                five_proportion=(double) uncallcount/sumnumcount;

            }else {
                one_proportion=0;
                two_proportion=0;
                three_proportion=0;
                four_proportion=0;
                five_proportion=0;
            }

            ChanStatistics chanStatistic=new ChanStatistics();
            chanStatistic.setChannel_id(channel.getChannel_id());
            chanStatistic.setChannel_type(channel.getChannel_type());
            chanStatistic.setOnOffline(channel.getOnOffline());
            chanStatistic.setCampus_id(channel.getCampus_id());

            chanStatistic.setCount_effective(effectivecount);
            chanStatistic.setCount_wait(waitcount);
            chanStatistic.setCount_uneffective(uneffectivecount);
            chanStatistic.setCount_uncontect(uncontect);
            chanStatistic.setCount_uncall(uncallcount);
            chanStatistic.setCount_sumnum(sumnumcount);

            chanStatistic.setOne_proportion(one_proportion);
            chanStatistic.setTwo_proportion(two_proportion);
            chanStatistic.setThree_proportion(three_proportion);
            chanStatistic.setFour_proportion(four_proportion);
            chanStatistic.setFive_proportion(five_proportion);

            chanStatistic.setTime_start(time_start);
            chanStatistic.setTime_end(time_end);

            ChanStatistics isExit=chanStatisticsDao.chanStatisticIsExit(channel.getChannel_id(),channel.getCampus_id());

            if (isExit!=null){
                chanStatisticsDao.updateStatisticsByTime(chanStatistic);
            }else{
                chanStatisticsDao.insertChannelStatistics(chanStatistic);

            }

        }
    }



}
