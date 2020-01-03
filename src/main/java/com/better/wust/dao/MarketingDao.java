package com.better.wust.dao;

import com.better.wust.entity.Channel;
import com.better.wust.entity.Marketing;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketingDao {

    /**
     * 搜索市场营销活动
     * @param selectEntity
     * @return
     */
    public List<Marketing> findAllMarketingList(SelectEntity selectEntity);

    /**
     * 获取市场营销活动数
     * @return
     */
    public int getAllMarketingNumber(SelectEntity selectEntity);

    /**
     * 添加一个市场活动
     *
     * @param marketing
     */
    public void insertMarketing(Marketing marketing);

    /**
     * 更新一个市场活动
     *
     * @param marketing
     */
    public void updateMarketing(Marketing marketing);

    /**
     * 获取最后一条记录的id
     *
     * @return
     */
    public String getLastId();

    /**
     * 删除一个市场活动
     *
     * @param id
     */
    public void delMarekting(String id);

    /**
     * 更新备用文件一
     *
     * @param marketing
     */
    public void updateUrl_first(Marketing marketing);

    /**
     * 更新备用文件二
     *
     * @param marketing
     */
    public void updateUrl_second(Marketing marketing);


    /**
     * 搜索市场营销活动
     * @return
     */
    public List<Marketing> selectAllMarketingNames();



    public List<Marketing> findAllMarketingNameByChannel(String channel_id);

    public int findAllMarketingNameNumByChannel(String channel_id);

    public List<Marketing> findAllMarketing();

    public int statisticsMarketingEffective(String marketing);

    public int statisticsMarketingWait(String marketing_id);

    public int statisticsMarketingUnEffective(String marketing);

    public int statisticsMarketingUncontect(String marketing_id);

    public int statisticsMarketingUncall(String marketing);

    public int statisticsMarketingSumnum(String marketing);




    public void updateMarketingStatistics(Marketing marketing);




}
