package com.better.wust.controller;

import com.better.wust.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class GotoJspController {

    @RequestMapping(value = "gotoJsp", method = RequestMethod.GET)
    public String gotoJsp(HttpServletRequest request, Model model, String jsp, String type, String con) {
        model.addAttribute("url", jsp.replaceAll("/", "-"));
        // con为加载内容
        model.addAttribute("con", con);
        return jsp;
    }

    // 加载系统
    @RequestMapping(value = "loadSystem", method = RequestMethod.GET)
    public String loadSystem(HttpServletRequest request, Model model) {
        return "login";
    }

    @RequestMapping(value = "loginOut", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request, Model model, String jsp) {
        request.getSession().removeAttribute("staff");
        return "redirect:gotoLogin";
    }

    @RequestMapping(value = "gotoLogin", method = RequestMethod.GET)
    public String gotoLogin(HttpServletRequest request, Model model, String jsp) {
        return "login";
    }


    @RequestMapping(value = "gotoSale", method = RequestMethod.GET)
    public String gotoSale(HttpServletRequest request, Model model, String jsp) {
        return "staff/mySale";
    }

    @RequestMapping(value = "gotoSign", method = RequestMethod.GET)
    public String gotoSign(HttpServletRequest request, Model model, String jsp) {
        return "staff/mySign";
    }

}
