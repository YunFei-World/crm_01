package com.better.wust.controller;

import com.better.wust.entity.CourseStatistics;
import com.better.wust.entity.SaleReasonStatistics;
import com.better.wust.service.SaleReasonStatisticsService;
import com.better.wust.tools.entity.SelectEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("saleReasonStatistics")
public class SaleReasonStatisticsController {
    @Autowired
    private SaleReasonStatisticsService saleReasonStatisticsService;



    @RequestMapping(value = "findAllSaleReasonStatisticsList", method = RequestMethod.GET)
    public void findAllSaleReasonStatisticsList(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                                String[] filter,String staff_id, String campus_id,String sale_stage ) {
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
                if (sale_stage==""){
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')  and sale_stage IN ('A-待定','C-拒绝')";
                }else{
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')  and sale_stage='"+sale_stage+"'";
                }

            } else {
                if (sale_stage==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and sale_stage IN ('A-待定','C-拒绝')";
                }else{
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and sale_stage='"+sale_stage+"'";
                }

            }
        } else {
            if (key == null) {
                if (sale_stage==""){
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and sale_stage IN ('A-待定','C-拒绝')";
                }else {
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and  sale_stage='"+sale_stage+"'";
                }

            } else {
                if (sale_stage==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and  sale_stage IN ('A-待定','C-拒绝')";
                }else {
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and  sale_stage='"+sale_stage+"'";
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
            field = "sale_stage";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<SaleReasonStatistics> list = saleReasonStatisticsService.findAllSaleReasonStatisticsList(selectEntity);
        int num=saleReasonStatisticsService.getAllSaleReasonStatisticsNumber(selectEntity);
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
    public void updateStatisticsByTime(HttpServletResponse response,String time_start,String time_end,String campus_id ,String sale_stage) {
        response.setCharacterEncoding("UTF-8");
        int code = 100;
        JSONObject json = new JSONObject();
        saleReasonStatisticsService.updateStatisticsByTime(time_start,time_end,campus_id,sale_stage);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
