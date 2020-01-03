package com.better.wust.controller;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Sale;
import com.better.wust.service.ChanStatisticsService;
import com.better.wust.tools.JsonUtils;
import com.better.wust.tools.entity.SelectEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("chanStatistics")
public class ChanStatisticsController {

    @Autowired
    private ChanStatisticsService chanStatisticsService;


    @RequestMapping(value = "findAllChanStatisticsList", method = RequestMethod.GET)
    public void findAllChanStatisticsList(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                      String[] filter, String staff_id, String campus_id ) {

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
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "'";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "'";
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
        List<ChanStatistics> list =chanStatisticsService.findAllChanStatisticsList(selectEntity);
        int num = chanStatisticsService.getAllChanStatisticsNumber(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
        json.put("code", 0);
        json.put("count",num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "updateStatisticsByTime", method = RequestMethod.GET)
    public void updateStatisticsByTime(HttpServletResponse response,String time_start,String time_end ) {
        response.setCharacterEncoding("UTF-8");
        int code = 100;
        JSONObject json = new JSONObject();
        chanStatisticsService.updateStatisticsByTime(time_start,time_end);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /*@RequestMapping(value = "getChanStatistics", method = RequestMethod.GET)
    public void getChecksBySE(HttpServletResponse response, int page, int limit, String field, String order, String key,
                              String[] filter, String staff_id, String campus_id) {
        // 构建查询语句
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(statistics_month,'')";
        }

        if (campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "'";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "'";
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
            field = "statistics_month";
            order = "desc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<ChanStatistics> list = chanStatisticsService.getChanStatistics(selectEntity);
        int num = chanStatisticsService.getChanStatisticsNumber(selectEntity);
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

    @RequestMapping(value = "statisticsMonth", method = RequestMethod.GET)
    public void statisticsMonth(HttpServletResponse response, HttpServletRequest request, String month, String staff_id, String campus_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        chanStatisticsService.statisticsMonth(month,staff_id,campus_id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
