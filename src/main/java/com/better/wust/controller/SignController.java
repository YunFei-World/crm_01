package com.better.wust.controller;

import com.better.wust.entity.*;
import com.better.wust.service.SignService;
import com.better.wust.tools.JsonUtils;
import com.better.wust.tools.entity.SelectEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("sign")
public class SignController {

    @Autowired
    private SignService signService;

    @RequestMapping(value = "findSignById", method = RequestMethod.GET)
    public void findSignById(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sign_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and assign_staff_id = " + "'" +staff_id + "'";
        } else {
            key = "concat(concat('%"+ key +"%'))" + " and assign_staff_id = " + "'" +staff_id + "'";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "load_time ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<SignSql> list = signService.findSignsById(selectEntity);
        int num = signService.getSignNumberById(selectEntity);
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



    /**
     * 更新市场活动
     *
     * @param response
     * @param request
     * @param sign
     */
    @RequestMapping(value = "updateSign", method = RequestMethod.GET)
    public void updateSign(HttpServletResponse response, HttpServletRequest request, Sign sign,String all_course) {
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");
        //100 成功所选课程全部录入  101（学生已经选择了某些课程了）


        String[] ids=all_course.split(",");


        List<String> course_list=new ArrayList<>(10);
        String course_name="";
        String sign_course_id="";
        String sign_course_name="";

        int code=100;

        double all_real_price=0.00;

        //1.添加学生
        Student student=signService.addStudent(sign);


        //查看学生-课程表信息 ，看选课程是否正在上
        for(String id:ids){
            Course course=signService.findCourseById(Integer.parseInt(id));
            StudentClass studentClass=signService.findStudentClassByID(student.getId(),course.getId(),0);
            //计算每个课程实际成交价格的总和
            all_real_price=all_real_price+course.getTotalPrice();
            if (studentClass!=null){
                course_list.add(course.getCOURSE_NAME());
            }
        }





        if (course_list.size()!=0){
            code=101;
            for (String name:course_list){
                course_name=course_name+name+" ";
            }
        }else{
            //2.更新学生-课程表信息
            Sign mysign=new Sign();
            mysign.setSign_id(sign.getSign_id());
            for (String id : ids) {
                Course course=signService.findCourseById(Integer.parseInt(id));

                double course_real_price=(course.getTotalPrice()/all_real_price)*sign.getFinal_price();
                double course_reward_balance=course.getTotalPrice()-course_real_price;


                mysign.setCourse_id(Integer.parseInt(id));
                mysign.setOrder_course_num(course.getLessonNum());
                mysign.setFinal_price(course_real_price);
                mysign.setReward_balance(course_reward_balance);

                signService.addStudentCourse(mysign,student.getStudent_id());


                if (sign_course_id==""){
                    sign_course_id=id;
                    sign_course_name=course.getCOURSE_NAME();
                }else{
                    sign_course_id=sign_course_id+"-"+id;
                    sign_course_name=sign_course_name+"-"+course.getCOURSE_NAME();
                }

            }
            //3.更新订单信息

            SignSql signSql=new SignSql();
            signSql.setCustomer_name(sign.getCustomer_name());
            signSql.setCustomer_contact(sign.getCustomer_contact());
            signSql.setSign_id(sign.getSign_id());
            signSql.setCourse_id(sign_course_id);
            signSql.setCourse_name(sign_course_name);

            signSql.setSign_date(sign.getSign_date());
            signSql.setLoad_time(sign.getLoad_time());

            signSql.setStudent_sex(sign.getStudent_sex());
            signSql.setStudent_birthday(sign.getStudent_birthday());
            signSql.setStudent_phone(sign.getStudent_phone());

            signSql.setFinal_price(sign.getFinal_price());
            signSql.setReward_balance(all_real_price-sign.getFinal_price());
            signSql.setOrder_course_num(all_real_price);

            signSql.setRelation(sign.getRelation());
            signSql.setStu_name(sign.getStu_name());
            signSql.setStudent_id(student.getStudent_id());
            signSql.setRemark(sign.getRemark());


            code =signService.modifySign(signSql);
        }


        json.put("code", code);
        json.put("course_name",course_name);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找订单中所有选购的课程信息

     */
    @RequestMapping(value = "findAllSignCourseBySignId", method = RequestMethod.GET)
    public void findAllSignCourseBySignId(HttpServletResponse response, HttpServletRequest request, String sign_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        List<SignCourse> list = signService.findAllSignCourseBySignId(sign_id);
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    @RequestMapping(value = "findAllCourseNames", method = RequestMethod.GET)
    public void findAllCourseNames(HttpServletResponse response, HttpServletRequest request,String campus_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        List<Course> list = signService.findAllCourseNames(campus_id);
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "findAllSign", method = RequestMethod.GET)
    public void findAllSign(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                            String field, String order, String key, String[] filter, String staff_id, String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sign_id,'')";
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
            field = " load_time";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<SignSql> list = signService.findAllSigns(selectEntity);
        int num = signService.getSignNumber(selectEntity);
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


    /**
     * 跳转界面 打印
     * @param request
     * @param model
     * @param
     * @param jsp
     * @return
     */
    @RequestMapping(value = "gotoJsp", method = RequestMethod.GET)
    public String gotoJsp(HttpServletRequest request, Model model, String sign_id, String staff_id,String campus_id,String jsp) {
        model.addAttribute("sign", signService.findSignBySignId(sign_id));
        model.addAttribute("staff", signService.findStaffByStaffId(staff_id));
        model.addAttribute("campus", signService.findCampusByCampusId(campus_id));
        return "pop/" + jsp;
    }


}
