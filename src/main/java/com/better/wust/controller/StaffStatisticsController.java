package com.better.wust.controller;

import com.better.wust.entity.*;
import com.better.wust.service.SaleStatisticsService;
import com.better.wust.service.StaffStatisticsService;
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
@RequestMapping("staffStatistics")
public class StaffStatisticsController {

    @Autowired
    private StaffStatisticsService staffStatisticsService;

    //时间段
    @RequestMapping(value = "findAllStaffTimeStatisticsList", method = RequestMethod.GET)
    public void findAllStaffTimeStatisticsList(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                           String[] filter,String staff_id, String campus_id ) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(staff_post,'')";
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
            field = "staff_post ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<StaffStatisticsTime> list = staffStatisticsService.findAllStaffTimeStatisticsList(selectEntity);
        int num = staffStatisticsService.getAllStaffTimeStatisticsNumber(selectEntity);
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
    public void updateStatisticsByTime(HttpServletResponse response,String time_start,String time_end,String staff_id,String campus_id ) {
        response.setCharacterEncoding("UTF-8");
        int code = 100;
        JSONObject json = new JSONObject();
        staffStatisticsService.updateStatisticsByTime(time_start,time_end,staff_id,campus_id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //时间段  end



    //月-周统计
    @RequestMapping(value = "getStatisticsStaffMonth", method = RequestMethod.GET)
    public void getStatisticsStaffMonth(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                      String[] filter,String staff_id, String campus_id) {
        // 构建查询语句
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(month,'')";
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
            field = "month desc,start_date";
            order = "desc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<StaffStatisticsMonth> list = staffStatisticsService.getStatisticsStaffMonth(selectEntity);
        int num = staffStatisticsService.getStatisticsStaffMonthNumber(selectEntity);
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

    @RequestMapping(value = "statisticsStaffMonth", method = RequestMethod.GET)
    public void statisticsStaffMonth(HttpServletResponse response, HttpServletRequest request, StaffStatisticsMonth staffStatisticsMonth) {
        JSONObject json = new JSONObject();
        if (staffStatisticsMonth.getCampus_id() == null){
            staffStatisticsMonth.setCampus_id(-1);
        }
        int code = staffStatisticsService.statisticsStaffMonth(staffStatisticsMonth);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //月-周统计 end

/*
    @RequestMapping(value = "getStatisticsStaffDayDetailed", method = RequestMethod.GET)
    public void getStatisticsStaffDayDetailed(HttpServletResponse response, int page, int limit, String field, String order,StaffStatisticsWeek staffStatisticsWeek) {
        // 构建查询语句
        String sql = "";
        sql = "staff_id='" + staffStatisticsWeek.getStaff_id() +"'" + " AND statistics_date >= '" + staffStatisticsWeek.getStart_date() +"'" + " AND statistics_date <= '" + staffStatisticsWeek.getEnd_date()  +"'";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "statistics_date";
            order = "desc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<StaffStatisticsDay> list = staffStatisticsService.getStatisticsStaffDayDetailed(selectEntity);
        int num = staffStatisticsService.getStatisticsStaffDayDetailedNumber(selectEntity);
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


    @RequestMapping(value = "statisticsStaffMonth", method = RequestMethod.GET)
    public void statisticsStaffMonth(HttpServletResponse response, HttpServletRequest request, StaffStatisticsMonth staffStatisticsMonth) {
        JSONObject json = new JSONObject();
        if (staffStatisticsMonth.getCampus_id() == null){
            staffStatisticsMonth.setCampus_id(-1);
        }
        int code =staffStatisticsService.statisticsStaffMonth(staffStatisticsMonth);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "getStatisticsStaffMonth", method = RequestMethod.GET)
    public void getStatisticsStaffMonth(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                      String[] filter,String staff_id, String campus_id) {
        // 构建查询语句
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(month,'')";
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
            field = "month";
            order = "desc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<StaffStatisticsMonth> list = staffStatisticsService.getStatisticsStaffMonth(selectEntity);
        int num = staffStatisticsService.getStatisticsStaffMonthNumber(selectEntity);
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

    @RequestMapping(value = "statisticsTaskMonth", method = RequestMethod.GET)
    public void statisticsTaskMonth(HttpServletResponse response, HttpServletRequest request, SaleTask saleTask) {
        JSONObject json = new JSONObject();
        if (saleTask.getCampus_id() == null){
            saleTask.setCampus_id(-1);
        }
        int code =staffStatisticsService.statisticsTaskMonth(saleTask);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "getStatisticsTaskMonth", method = RequestMethod.GET)
    public void getStatisticsTaskMonth(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                        String[] filter,String staff_id, String campus_id) {
        // 构建查询语句
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(month,'')";
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
            field = "month";
            order = "desc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<SaleTask> list = staffStatisticsService.getStatisticsTaskMonth(selectEntity);
        int num = staffStatisticsService.getStatisticsTaskMonthNumber(selectEntity);
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
    }*/

}
