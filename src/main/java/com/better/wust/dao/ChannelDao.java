package com.better.wust.dao;

import com.better.wust.entity.Channel;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelDao {

    //查询所有渠道
    public List<Channel> selectAllChannel(SelectEntity selectEntity);

    public int selectChannelNumber(SelectEntity selectEntity);



    public void insertChannel(Channel channel);

    public void updateChannel(Channel channel);

    public String getLastId();

    public void deleteChannel(String id);

    public List<Channel> selectAllChannelNames(@Param("staff_id") String staff_id,@Param("campus_id") String campus_id);

    public List<Channel> selectAllChannelNamesByStaff(String campus_id);

    public List<Channel> findChannels();
}
