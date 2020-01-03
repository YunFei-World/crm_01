package com.better.wust.controller;

import com.better.wust.entity.Staff;
import com.better.wust.service.StaffService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 77
 */
@Controller
public class LoginController {

    @Autowired
    private StaffService staffService;





    @RequestMapping(value = "keepCampus", method = RequestMethod.GET)
    public void keepCampus(HttpServletRequest request, String campus_id, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            request.getSession().setAttribute("chooseCampusId",campus_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 登陆认证
     *
     * @param staff    页面传值
     * @param response 返回给页面
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public void login(HttpServletRequest request, Staff staff, String type, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        String power = "";
        int a = 0;
        a = staffService.verification(staff);
        power = staffService.findPowerById(staff);
        if (a > 0) {
            if (power != null) {
                Staff staffSave = staffService.getStaffData(staff.getStaff_id());
                Integer chooseCampusId=staffSave.getCampus_id();
                if ("0".equals(type) && "gotoJsp?jsp=staff/orderInit/myOrderinit".equals(power)) {
                   // request.getSession().setAttribute("chooseCampusId",chooseCampusId);
                    request.getSession().setAttribute("staff", staffSave);

                    json.put("code", 100);
                } else if ("1".equals(type) && "gotoJsp?jsp=staff/myInitSale".equals(power)) {
                    //request.getSession().setAttribute("chooseCampusId",chooseCampusId);
                    request.getSession().setAttribute("staff", staffSave);

                    json.put("code", 101);
                } else if ("2".equals(type) && "gotoJsp?jsp=staffManage".equals(power)) {
                    request.getSession().setAttribute("chooseCampusId",chooseCampusId);
                    request.getSession().setAttribute("staff", staffSave);
                    json.put("code", 102);
                } else {
                    json.put("msg", "你没有该登录权限!您是 " + staffSave.getStaff_depart());
                    json.put("code", 103);
                }
            } else {
                json.put("msg", "你没有登录权限!");
                json.put("code", 104);
            }
        } else {
            json.put("msg", "密码或者用户名输入有误");
            json.put("code", 105);
        }
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
