package com.better.wust.service.Impl;


import com.better.wust.dao.ChannelDao;
import com.better.wust.entity.Channel;
import com.better.wust.service.ChannelService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelDao channelDao;




    @Override
    public List<Channel> findChannels() {
        return channelDao.findChannels();
    }

    @Override
    public List<Channel> findAllChannel(SelectEntity selectEntity)throws RuntimeException{
        return channelDao.selectAllChannel(selectEntity);
    }

    @Override
    public int findChannelNumber(SelectEntity selectEntity) throws RuntimeException{
        return channelDao.selectChannelNumber(selectEntity);
    }

    @Override
    public String addChannel(Channel channel) throws RuntimeException {
        String id = getLastId();
        if (id == null) {
            id = "CHAN-1000";
        } else {
            id = "CHAN-" + (Integer.parseInt(id.split("-")[1]) + 1);
        }
        channel.setChannel_id(id);
        channelDao.insertChannel(channel);

        return id;
    }

    @Override
    public void modifyChannel(Channel channel) throws RuntimeException {
        channelDao.updateChannel(channel);
    }

    @Override
    public String getLastId() throws RuntimeException {
        return channelDao.getLastId();
    }

    @Override
    public void removeChannel(String id) throws RuntimeException {
        channelDao.deleteChannel(id);
    }

    @Override
    public List<Channel> findAllChannelNames(String staff_id,String campus_id) throws RuntimeException {
        return channelDao.selectAllChannelNames(staff_id,campus_id);
    }

    @Override
    public List<Channel> findAllChannelNamesByStaff(String campus_id) throws RuntimeException {
        return channelDao.selectAllChannelNamesByStaff(campus_id);
    }
}
