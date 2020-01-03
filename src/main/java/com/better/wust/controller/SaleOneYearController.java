package com.better.wust.controller;


import com.better.wust.entity.SaleOneYearFirst;
import com.better.wust.entity.SaleOneYearSecond;
import com.better.wust.entity.SaleOneYearThird;
import com.better.wust.service.SaleOneYearService;
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
@RequestMapping("saleoneyear")
public class SaleOneYearController {

    @Autowired
    private SaleOneYearService saleOneYearService;

    @RequestMapping(value = "updateSaleOneYearFirst", method = RequestMethod.GET)
    public void updateSaleOneYearFirst(HttpServletResponse response, HttpServletRequest request, String year, String campus_id) {
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        saleOneYearService.updateSaleOneYearFirst(year,Integer.parseInt(campus_id));
        int code=100;
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findAllSaleOneYearFirstList", method = RequestMethod.GET)
    public void findAllSaleOneYearFirstList(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                           String field, String order, String key, String[] filter,String staff_id,String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(month,'')";
        }
        if(campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            }
        }else {
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
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<SaleOneYearFirst> list = saleOneYearService.findAllSaleOneYearFirstList(selectEntity);
        int num = saleOneYearService.getAllSaleOneYearFirstNum(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    @RequestMapping(value = "updateSaleOneYearSecond", method = RequestMethod.GET)
    public void updateSaleOneYearSecond(HttpServletResponse response, HttpServletRequest request, String year, String campus_id) {
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        saleOneYearService.updateSaleOneYearSecond(year,Integer.parseInt(campus_id));
        int code=100;
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "findAllSaleOneYearSecondList", method = RequestMethod.GET)
    public void findAllSaleOneYearSecondList(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                            String field, String order, String key, String[] filter,String staff_id,String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(subject_id,'')";
        }
        if(campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            }
        }else {
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
            field = "subject_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<SaleOneYearSecond> list = saleOneYearService.findAllSaleOneYearSecondList(selectEntity);
        int num = saleOneYearService.getAllSaleOneYearSecondNum(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "updateSaleOneYearThird", method = RequestMethod.GET)
    public void updateSaleOneYearThird(HttpServletResponse response, HttpServletRequest request, String year, String campus_id) {
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        saleOneYearService.updateSaleOneYearThird(year,Integer.parseInt(campus_id));
        int code=100;
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "findAllSaleOneYearThirdList", method = RequestMethod.GET)
    public void findAllSaleOneYearThirdList(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                            String field, String order, String key, String[] filter,String staff_id,String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(month,'')";
        }
        if(campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')";
            }
        }else {
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
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<SaleOneYearThird> list = saleOneYearService.findAllSaleOneYearThirdList(selectEntity);
        int num = saleOneYearService.getAllSaleOneYearThirdNum(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
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
