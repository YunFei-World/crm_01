package com.better.wust.service.Impl;

import com.better.wust.dao.MarketingDao;
import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Channel;
import com.better.wust.entity.Marketing;
import com.better.wust.service.MarketingService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarketingServiceImpl implements MarketingService {

    @Autowired
    private MarketingDao marketingDao;


    @Override
    public void updateMarketingStatistics() {
        //统计  更新所有活动的统计信息
        List<Marketing> list = marketingDao.findAllMarketing();
        for (Marketing marketing : list) {

            int order_effective = marketingDao.statisticsMarketingEffective(marketing.getMarketing_id());//接通-有意到店
            int order_wait = marketingDao.statisticsMarketingWait(marketing.getMarketing_id());//接通-待定
            int order_uneffective = marketingDao.statisticsMarketingUnEffective(marketing.getMarketing_id());//接通-拒绝
            int order_uncontect = marketingDao.statisticsMarketingUncontect(marketing.getMarketing_id());//未接通
            int order_uncall = marketingDao.statisticsMarketingUncall(marketing.getMarketing_id());//未打电话

            int order_num = marketingDao.statisticsMarketingSumnum(marketing.getMarketing_id());//毛单总数
            double proportion;
            double proportion_two;
            double proportion_three;
            double proportion_four;
            double proportion_five;

            if (order_num!=0){
                proportion=(double) order_effective/order_num;
                proportion_two=(double) order_wait/order_num;
                proportion_three=(double) order_uneffective/order_num;
                proportion_four=(double) order_uncontect/order_num;
                proportion_five=(double) order_uncall/order_num;
            }else {
                proportion=0;
                proportion_two=0;
                proportion_three=0;
                proportion_four=0;
                proportion_five=0;
            }

            marketing.setOrder_effective(order_effective);
            marketing.setOrder_wait(order_wait);
            marketing.setOrder_uneffective(order_uneffective);
            marketing.setOrder_uncontect(order_uncontect);
            marketing.setOrder_uncall(order_uncall);

            marketing.setOrder_num(order_num);

            marketing.setProportion(proportion);
            marketing.setProportion_two(proportion_two);
            marketing.setProportion_three(proportion_three);
            marketing.setProportion_four(proportion_four);
            marketing.setProportion_five(proportion_five);


            marketingDao.updateMarketingStatistics(marketing);
        }
    }

    @Override
    public List<Marketing> findAllMarketingNameByChannel(String channel_id) {
        return marketingDao.findAllMarketingNameByChannel(channel_id);
    }


    @Override
    public int findAllMarketingNameNumByChannel(String channel_id) {
        return marketingDao.findAllMarketingNameNumByChannel(channel_id);
    }


    public List<Marketing> findAllMarketingList(SelectEntity selectEntity) throws RuntimeException {
        return marketingDao.findAllMarketingList(selectEntity);
    }

    @Override
    public int getAllMarketingNumber(SelectEntity selectEntity) throws RuntimeException {
        return marketingDao.getAllMarketingNumber(selectEntity);
    }

    @Override
    public String addMarketing(Marketing marketing) throws RuntimeException {
        String id = getLastId();
        if (id == null) {
            id = "MARK-1000";
        } else {
            id = "MARK-" + (Integer.parseInt(id.split("-")[1]) + 1);
        }
        marketing.setMarketing_id(id);
        marketingDao.insertMarketing(marketing);
        return id;
    }


    // 用于更新活动的信息
    @Override
    public void modifyMarketing(Marketing marketing) throws RuntimeException {
//        if (marketing.getOrder_num() == 0) {
//            marketing.setProportion(0.0);
//        } else {
//            marketing.setProportion(marketing.getOrder_effective() * 1.0 / marketing.getOrder_num());
//        }

        marketingDao.updateMarketing(marketing);
    }

    @Override
    public String getLastId() throws RuntimeException {
        return marketingDao.getLastId();
    }

    @Override
    public void removeMarketing(String id) throws RuntimeException {
        marketingDao.delMarekting(id);
    }

    @Override
    public void modifyUrl_first(Marketing marketing) throws RuntimeException {
        marketingDao.updateUrl_first(marketing);
    }

    @Override
    public void modifyUrl_second(Marketing marketing) throws RuntimeException {
        marketingDao.updateUrl_second(marketing);
    }

    @Override
    public List<Marketing> findAllMarketingNames() {
        return marketingDao.selectAllMarketingNames();
    }


}
