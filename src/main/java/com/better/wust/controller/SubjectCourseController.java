package com.better.wust.controller;

import com.better.wust.entity.*;
import com.better.wust.service.SubjectCourseService;
import com.better.wust.tools.entity.SelectEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("subjectCourse")
public class SubjectCourseController {

    @Autowired
    private SubjectCourseService subjectCourseService;


    @RequestMapping(value = "findAllSubject", method = RequestMethod.GET)
    public void findAllSubject(HttpServletResponse response ) {
        response.setCharacterEncoding("UTF-8");
        List<Subject> list =subjectCourseService.findAllSubject();
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", 0);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @RequestMapping(value = "findAllCourseStatisticsList", method = RequestMethod.GET)
    public void findAllCourseStatisticsList(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                        String[] filter,String staff_id, String campus_id,String subject_id) {
        // 构建查询语句
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(time_start,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                if (subject_id==""){
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')  and subject_id IN (SELECT Id FROM jw_subject)";
                }else{
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')  and subject_id='"+subject_id+"'";
                }

            } else {
                if (subject_id==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and subject_id IN (SELECT Id FROM jw_subject)";
                }else{
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and subject_id='"+subject_id+"'";
                }

            }
        } else {
            if (key == null) {
                if (subject_id==""){
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and subject_id IN (SELECT Id FROM jw_subject)";
                }else {
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and  subject_id='"+subject_id+"'";
                }

            } else {
                if (subject_id==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and  subject_id IN (SELECT Id FROM jw_subject)";
                }else {
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and  subject_id='"+subject_id+"'";
                }

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
            field = "campus_id ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<CourseStatistics> list = subjectCourseService.findAllCourseStatisticsList(selectEntity);
        int num=subjectCourseService.getAllCourseStatisticsListNumber(selectEntity);
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
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
    public void updateStatisticsByTime(HttpServletResponse response, String time_start, String time_end, String campus_id, String subject_id ) {
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        subjectCourseService.updateStatisticsByTime(time_start,time_end,campus_id,subject_id);
        int code = 100;
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




//    科目月销售统计

    @RequestMapping(value = "updateSubjectStatisticsByTime", method = RequestMethod.GET)
    public void updateSubjectStatisticsByTime(HttpServletResponse response, HttpServletRequest request, String time_start, String time_end, String campus_id) {
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        subjectCourseService.updateSubjectStatisticsByTime(time_start,time_end,campus_id);
        int code=100;
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findAllSubjectStatisticsList", method = RequestMethod.GET)
    public void findAllSubjectStatisticsList(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                        String[] filter,String staff_id,String campus_id,String subject_id) {
        // 构建查询语句
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(time_start,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                if (subject_id==""){
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')  and subject_id IN (SELECT Id FROM jw_subject)";
                }else{
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')  and subject_id='"+subject_id+"'";
                }

            } else {
                if (subject_id==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and subject_id IN (SELECT Id FROM jw_subject)";
                }else{
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and subject_id='"+subject_id+"'";
                }

            }
        } else {
            if (key == null) {
                if (subject_id==""){
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and subject_id IN (SELECT Id FROM jw_subject)";
                }else {
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and  subject_id='"+subject_id+"'";
                }

            } else {
                if (subject_id==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and  subject_id IN (SELECT Id FROM jw_subject)";
                }else {
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and  subject_id='"+subject_id+"'";
                }

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
            field = "subject_id desc,campus_id ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<SubjectStatistics> list = subjectCourseService.findAllSubjectStatisticsList(selectEntity);
        int num = subjectCourseService.getAllSubjectStatisticsListNumber(selectEntity);
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

}
