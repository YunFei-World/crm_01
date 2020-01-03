package com.better.wust.service.Impl;

import com.better.wust.dao.ChanStatisticsDao;
import com.better.wust.dao.SaleStatisticsDao;
import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Sale;
import com.better.wust.entity.SaleStatistics;
import com.better.wust.service.ChanStatisticsService;
import com.better.wust.service.SaleStatisticsService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.SoundbankResource;
import java.util.List;

@Service
@Transactional
public class SaleStatisticsServiceImpl implements SaleStatisticsService {

    @Autowired
    private SaleStatisticsDao saleStatisticsDao;





    @Override
    public List<SaleStatistics> getSaleStatistics(SelectEntity selectEntity) {
        return saleStatisticsDao.selectSaleStatistics(selectEntity);
    }

    @Override
    public int getSaleStatisticsNumber(SelectEntity selectEntity) {
        return saleStatisticsDao.selectSaleStatisticsNumber(selectEntity);
    }

    @Override
    public void statisticsSaleMonth(String month, String staff_id, String campus_id) {
        List<SaleStatistics> list = saleStatisticsDao.statisticsSaleMonth(month,staff_id,campus_id);
        for (SaleStatistics saleStatistics : list) {
            saleStatistics.setStatistics_month(month);
            SaleStatistics isExist = saleStatisticsDao.statisticsIsExist(saleStatistics);
            if (isExist != null){
                saleStatisticsDao.updateStatisticsBySaleAndMonth(saleStatistics);
            } else {
                saleStatisticsDao.insertStatistics(saleStatistics);
            }
        }
    }


    //my
    @Override
    public List<SaleStatistics> findAllSaleStageStatisticsList(SelectEntity selectEntity) {
        return saleStatisticsDao.findAllSaleStageStatisticsList(selectEntity);
    }


    @Override
    public int getAllSaleStatisticsNumber(SelectEntity selectEntity) {
        return saleStatisticsDao.getAllSaleStatisticsNumber(selectEntity);
    }

    @Override
    public void updateStatisticsByTime(String time_start,String time_end,String campus_id) {
        List<SaleStatistics> list = saleStatisticsDao.findAllSaleStageStatistics(campus_id);
        time_end=time_end+" 23:59:59";
        for (SaleStatistics saleStatistics : list) {
            int effectivecount = saleStatisticsDao.statisticsSaleStageNumByTime(time_start,time_end,saleStatistics.getSale_stage(),saleStatistics.getCampus_id()+"");
            int sumnumcount = saleStatisticsDao.statisticsSaleStageSumNumByTime(time_start,time_end,saleStatistics.getCampus_id()+"");


            double proportion;
            if (sumnumcount!=0){
                proportion=(double) effectivecount/sumnumcount;
            }else {
                proportion=0;
            }

            saleStatistics.setTime_start(time_start);
            saleStatistics.setTime_end(time_end);
            saleStatistics.setStage_count(effectivecount);
            saleStatistics.setSum_count(sumnumcount);
            saleStatistics.setProportion(proportion);


            saleStatisticsDao.updateStatisticsByTime(saleStatistics);
        }
    }

}
