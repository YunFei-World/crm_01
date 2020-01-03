package com.better.wust.controller;

import com.better.wust.entity.TransRecord;
import com.better.wust.service.TransRecordService;
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
import java.util.List;

@Controller
@RequestMapping("transRecord")
public class TransRecordController {

    @Autowired
    private TransRecordService transRecordService;

    @RequestMapping(value = "findAllTransRecord", method = RequestMethod.GET)
    public void findAllTransRecord(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                             String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(trans_id,'')";
        }
        if (key == null) {
            key = "";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "trans_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<TransRecord> list = transRecordService.findAllTransRecords(selectEntity);
        int num = transRecordService.getTransRecordNumber(selectEntity);
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


    @RequestMapping(value = "findAllTransRecordSecond", method = RequestMethod.GET)
    public void findAllTransRecordSecond(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                   String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(trans_id,'')";
        }
        if (key == null) {
            key = "";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "trans_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<TransRecord> list = transRecordService.findAllTransRecordsSecond(selectEntity);
        int num = transRecordService.getTransRecordSecondNumber(selectEntity);
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

}
