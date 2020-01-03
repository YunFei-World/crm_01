package com.better.wust.service;

import com.better.wust.entity.Channel;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface ChannelService {


    public List<Channel> findAllChannel(SelectEntity selectEntity);

    public int findChannelNumber(SelectEntity selectEntity);

    public String addChannel(Channel channel);

    public void modifyChannel(Channel channel);

    public String getLastId();

    public void removeChannel(String id);

    public List<Channel> findAllChannelNames(String staff_id,String campus_id);

    public List<Channel> findAllChannelNamesByStaff(String campus_id);

    public List<Channel> findChannels();
}
