package com.better.wust.service;

import com.better.wust.entity.Channel;
import com.better.wust.entity.Marketing;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface MarketingService {

    public List<Marketing> findAllMarketingList(SelectEntity selectEntity);

    public int getAllMarketingNumber(SelectEntity selectEntity);

    public String addMarketing(Marketing marketing);

    public void modifyMarketing(Marketing marketing);

    public String getLastId();

    public void removeMarketing(String id);

    public void modifyUrl_first(Marketing marketing);

    public void modifyUrl_second(Marketing marketing);

    public List<Marketing> findAllMarketingNames();

    public List<Marketing> findAllMarketingNameByChannel(String channel_id);

    public int findAllMarketingNameNumByChannel(String channel_id);

    public void updateMarketingStatistics();


}
