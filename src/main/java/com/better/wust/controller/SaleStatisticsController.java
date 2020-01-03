package com.better.wust.controller;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Sale;
import com.better.wust.entity.SaleStatistics;
import com.better.wust.service.ChanStatisticsService;
import com.better.wust.service.SaleStatisticsService;
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
@RequestMapping("saleStatistics")
public class SaleStatisticsController {

    @Autowired
    private SaleStatisticsService saleStatisticsService;



    @RequestMapping(value = "findAllSaleStageStatisticsList", method = RequestMethod.GET)
    public void findAllSaleStageStatisticsList(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                      String[] filter, String staff_id, String campus_id ) {
        // 构建查询语句
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sale_stage,'')";
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
            field = "sale_stage";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<SaleStatistics> list = saleStatisticsService.findAllSaleStageStatisticsList(selectEntity);
        int num = saleStatisticsService.getAllSaleStatisticsNumber(selectEntity);
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



    @RequestMapping(value = "updateStatisticsByTime", method = RequestMethod.GET)
    public void updateStatisticsByTime(HttpServletResponse response,String time_start,String time_end,String campus_id ) {
        response.setCharacterEncoding("UTF-8");
        int code = 100;
        JSONObject json = new JSONObject();
        saleStatisticsService.updateStatisticsByTime(time_start,time_end,campus_id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    @RequestMapping(value = "getSaleStatistics", method = RequestMethod.GET)
    public void getSaleStatistics(HttpServletResponse response, int page, int limit, String field, String order, String key,
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
        List<SaleStatistics> list = saleStatisticsService.getSaleStatistics(selectEntity);
        int num = saleStatisticsService.getSaleStatisticsNumber(selectEntity);
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

    @RequestMapping(value = "statisticsSaleMonth", method = RequestMethod.GET)
    public void statisticsSaleMonth(HttpServletResponse response, HttpServletRequest request, String month,String staff_id,String campus_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        saleStatisticsService.statisticsSaleMonth(month,staff_id,campus_id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
