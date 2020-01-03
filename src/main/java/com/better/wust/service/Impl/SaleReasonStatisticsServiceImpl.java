package com.better.wust.service.Impl;


import com.better.wust.dao.SaleReasonStatisticsDao;
import com.better.wust.entity.SaleReasonStatistics;
import com.better.wust.entity.SaleStatistics;
import com.better.wust.service.SaleReasonStatisticsService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleReasonStatisticsServiceImpl implements SaleReasonStatisticsService {

    @Autowired
    SaleReasonStatisticsDao saleReasonStatisticsDao;


    @Override
    public List<SaleReasonStatistics> findAllSaleReasonStatisticsList(SelectEntity selectEntity) {
        return saleReasonStatisticsDao.findAllSaleReasonStatisticsList(selectEntity);
    }

    @Override
    public int getAllSaleReasonStatisticsNumber(SelectEntity selectEntity) {
        return saleReasonStatisticsDao.getAllSaleReasonStatisticsNumber(selectEntity);
    }

    @Override
    public List<SaleReasonStatistics> findAllSaleReasonStatistics(String campus_id,String sale_stage) {
        return saleReasonStatisticsDao.findAllSaleReasonStatistics(campus_id);
    }

    @Override
    public void updateStatisticsByTime(String time_start, String time_end, String campus_id,String sale_stage) {
        List<SaleReasonStatistics> list = saleReasonStatisticsDao.findAllSaleReasonStatistics(campus_id);
        time_end=time_end+" 23:59:59";
        for (SaleReasonStatistics saleReasonStatistics : list) {

            int effectivecount = saleReasonStatisticsDao.statisticsSaleReasonNumByTime(time_start,time_end,saleReasonStatistics.getFalse_reason(),saleReasonStatistics.getSale_stage(),saleReasonStatistics.getCampus_id()+"");
            int sumnumcount = saleReasonStatisticsDao.statisticsSaleReasonSumNumByTime(time_start,time_end,saleReasonStatistics.getSale_stage(),saleReasonStatistics.getCampus_id()+"");

            double proportion;
            if (sumnumcount!=0){
                proportion=(double) effectivecount/sumnumcount;
            }else {
                proportion=0;
            }
            saleReasonStatistics.setReason_count(effectivecount);
            saleReasonStatistics.setReason_sum_count(sumnumcount);
            saleReasonStatistics.setTime_start(time_start);
            saleReasonStatistics.setTime_end(time_end);
            saleReasonStatistics.setProportion(proportion);



            saleReasonStatisticsDao.updateStatisticsByTime(saleReasonStatistics);
        }
    }
}
