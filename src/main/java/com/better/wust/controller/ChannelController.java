package com.better.wust.controller;

import com.better.wust.entity.Channel;
import com.better.wust.entity.Marketing;
import com.better.wust.service.ChannelService;
import com.better.wust.service.MarketingService;
import com.better.wust.tools.entity.SelectEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;


    @Autowired
    private MarketingService marketingService;


    @RequestMapping(value = "findChannels", method = RequestMethod.GET)
    public void findChannels(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        List<Channel> list = channelService.findChannels();
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findMyChannel", method = RequestMethod.GET)
    public void findMyChannel(HttpServletRequest request, HttpServletResponse response, int page, int limit, String field,
                               String order, String key, String[] filter,String staff_id) {
        String sql = "";

        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(channel_id,'')";
        }

        if (key == null) {
            key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM staff WHERE staff_id = '" + staff_id + "')" + "and state='0'";
        } else {
            key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM staff WHERE staff_id = '" + staff_id + "')" + "and state='0'";
        }

        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "channel_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Channel> list = channelService.findAllChannel(selectEntity);
        int num = channelService.findChannelNumber(selectEntity);
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "findAllChannel", method = RequestMethod.GET)
    public void findAllChannel(HttpServletRequest request, HttpServletResponse response, int page, int limit, String field,
                               String order, String key, String[] filter,String staff_id, String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(channel_id,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')" + "and state='0'";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')" + "and state='0'";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "'" + "and state='0'";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "'" + " and state='0'";
            }
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "channel_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Channel> list = channelService.findAllChannel(selectEntity);
        int num = channelService.findChannelNumber(selectEntity);
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加渠道
     *
     * @param response
     * @param request
     * @param channel
     */
    @RequestMapping(value = "addChannel", method = RequestMethod.POST)
    public void addMarketing(HttpServletResponse response, HttpServletRequest request, Channel channel) {
        JSONObject json = new JSONObject();
        int code = 100;
        String id = "";
        id = channelService.addChannel(channel);
        json.put("id", id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新渠道
     *
     * @param response
     * @param request
     * @param channel
     */
    @RequestMapping(value = "updateChannel", method = RequestMethod.POST)
    public void updateMarketing(HttpServletResponse response, HttpServletRequest request, Channel channel) {
        JSONObject json = new JSONObject();
        int code = 100;
        String id = "";
        id = channel.getChannel_id();
        channelService.modifyChannel(channel);
        json.put("id",id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param response
     * @param request
     * @param id
     */
    @RequestMapping(value = "deleteChannel", method = RequestMethod.POST)
    public void deleteChannel(HttpServletResponse response, HttpServletRequest request, String id) {
        JSONObject json = new JSONObject();
        int code = 100;
        try {
            //判断渠道id下是否还有活动  有活动则禁止其删除

            if (marketingService.findAllMarketingNameNumByChannel(id)!=0){
                code=104;
            }else{
                channelService.removeChannel(id);
            }


        } catch (Exception e) {
            e.printStackTrace();
            code = 101;
        }


        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findAllChannelName", method = RequestMethod.GET)
    public void findAllChannelName(HttpServletResponse response, HttpServletRequest request,String staff_id, String campus_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        List<Channel> list = channelService.findAllChannelNames(staff_id,campus_id);
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findAllChannelNameByStaff", method = RequestMethod.GET)
    public void findAllChannelNameByStaff(HttpServletResponse response, HttpServletRequest request, String campus_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        List<Channel> list = channelService.findAllChannelNamesByStaff(campus_id);
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
