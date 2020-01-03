package com.better.wust.controller;

import com.better.wust.entity.*;
import com.better.wust.service.SaleService;
import com.better.wust.service.SignService;
import com.better.wust.tools.JsonUtils;
import com.better.wust.tools.StaticValues;
import com.better.wust.tools.entity.SelectEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("saleOrder")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SignService signService;





    @RequestMapping(value = "findSaleBySaleId", method = RequestMethod.GET)
    public void findSaleBySaleId(HttpServletResponse response, HttpServletRequest request,String sale_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        Sale sale= saleService.findSaleById(sale_id);
        json.put("code", code);
        json.put("sale", sale);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @RequestMapping(value = "findAllStudentUpdateCampus", method = RequestMethod.GET)
    public void findAllStudentUpdateCampus(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                     String field, String order, String key, String[] filter,String staff_id, String transfer_campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(student_id,'')";
        }
        if (transfer_campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')  and is_retire=2 ";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and is_retire=2";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and transfer_campus_id  = '" + transfer_campus_id + "' and is_retire=2";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and transfer_campus_id  = '" + transfer_campus_id + "' and is_retire=2";
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
            field = "student_id ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<StudentClass> list = saleService.findAllStudentUpdateCampus(selectEntity);
        int num = saleService.getAllStudentUpdateCampusNumber(selectEntity);
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


    @RequestMapping(value = "getStudentAllRealBalance", method = RequestMethod.GET)
    public void getStudentAllRealBalance(HttpServletResponse response, HttpServletRequest request,String student_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        double allbalance= saleService.getStudentAllRealBalance(Integer.parseInt(student_id));
        json.put("code", code);
        json.put("allbalance", allbalance);
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

    @RequestMapping(value = "finishStudentUpdateCampus", method = RequestMethod.POST)
    public void finishStudentUpdateCampus(HttpServletResponse response, HttpServletRequest request,Sign sign,String all_course,
                                          String real_balance_buy , String student_id,String transfer_campus_id ,String student_course_id) throws ParseException {
        /*response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        Sign sign=new Sign();
        sign.setReward_balance(Double.parseDouble("".equals(reward_balance.toString())?"0.00":reward_balance.toString()));
        sign.setOrder_course_num(Integer.parseInt("".equals(order_course_num.toString())?"0":order_course_num.toString()));
        sign.setFinal_price(Double.parseDouble("".equals(final_price.toString())?"0.00":final_price.toString()));
        sign.setSign_date(new SimpleDateFormat("yyyy-MM-dd").parse(sign_date));

        int code = saleService.finishStudentUpdateCampus(course_all,id,transfer_campus_id,student_id,sign,Double.parseDouble("".equals(real_balance_buy.toString())?"0.00":real_balance_buy.toString()));

        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        (HttpServletResponse response, HttpServletRequest request, String id, String transfer_campus_id, String student_id,
                                          String all_course, String reward_balance, String order_course_num, String final_price,
                                          String sign_date, String real_balance_buy )

        */


//--------------------------------------------------

        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");

        int code=100;
        String course_name="";
        double student_real_balance=saleService.getStudentAllRealBalance(Integer.parseInt(student_id));
        if (Double.parseDouble("".equals(real_balance_buy.toString())?"0.00":real_balance_buy.toString())>student_real_balance){
            code= 101;//学生余额不足够支付这个钱数
        }else{
            String[] ids=all_course.split(",");

            List<String> course_list=new ArrayList<>(10);

            String sign_course_id="";
            String sign_course_name="";

            double all_real_price=0.00;


            String sign_id = signService.selectLastSign();
            if (sign_id == null) {
                sign_id = "sign-1000";
            } else {
                sign_id = "sign-" + (Integer.parseInt(sign_id.split("-")[1]) + 1);
            }
            signService.insertSign(sign_id,"transCampus");
            sign.setSign_id(sign_id);


            //1.转校学生
            Student student=saleService.findStudentById(Integer.parseInt(student_id));
            //清空学生原校区课程
            saleService.cleanStudentCourse(student.getStudent_id());


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
                code=102;//学生已选过这么课
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
                signSql.setLoad_time(new Date());

                signSql.setStudent_sex(student.getStudent_sex());
                signSql.setStudent_birthday(student.getStudent_birthday());
                signSql.setStudent_phone(student.getStudent_phone());

                signSql.setFinal_price(sign.getFinal_price());
                signSql.setReward_balance(all_real_price-sign.getFinal_price());
                signSql.setOrder_course_num(all_real_price);

                signSql.setRelation(sign.getRelation());
                signSql.setStu_name(student.getStudent_name());
                signSql.setStudent_id(student.getStudent_id());
                signSql.setRemark(sign.getRemark());

                code =signService.modifySign(signSql);

                //4.更新学生信息（换校区成功）和学生课程表信息转换完成记录


                student.setReal_balance(student_real_balance-Double.parseDouble("".equals(real_balance_buy.toString())?"0.00":real_balance_buy.toString()));
                student.setCampus_id(Integer.parseInt(transfer_campus_id));
                student.setUpdate_time(new Timestamp((new Date()).getTime()));
                //将学生状态恢复为0变为正常状态
                student.setStudent_state(0);

                saleService.updateStudentByUpdateCampus(student);


                //更新学生课程表单  is_retire=4 表示学生已经更换校区完成 （查询所有表中对应该学生的所有学生课程项(将状态为2的 都变为4） ）
                saleService.finishStudentUpdateCampus(Integer.parseInt(student_id));


            }
        }


        json.put("code", code);
        json.put("course_name",course_name);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }





    }


    @RequestMapping(value = "findAllStudentRefund", method = RequestMethod.GET)
    public void findAllStudentRefund(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                            String field, String order, String key, String[] filter,String staff_id, String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(student_id,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and is_retire=1";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and is_retire=1";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and is_retire=1";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and is_retire=1";
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
            field = "update_loadtime ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<StudentClass> list = saleService.findAllStudentRefund(selectEntity);
        int num = saleService.getAllStudentRefundNumber(selectEntity);
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

    @RequestMapping(value = "finishStudentRefund", method = RequestMethod.POST)
    public void finishStudentRefund(HttpServletResponse response, HttpServletRequest request, String id,String student_id,String course_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        saleService.finishStudentRefund(Integer.parseInt(id),Integer.parseInt(student_id),Integer.parseInt(course_id));
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    @RequestMapping(value = "addInitAndSaleByComeToShop", method = RequestMethod.POST)
    public void addInitAndSaleByComeToShop(HttpServletResponse response, HttpServletRequest request, Orderinit orderinit) {
        JSONObject json = new JSONObject();
        int code = 100;
        saleService.addInitAndSaleByComeToShop(orderinit);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //管理员界面中的sale表查询和findAllSaleById没差别
    @RequestMapping(value = "findAllSale", method = RequestMethod.GET)
    public void findAllSale(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                              String field, String order, String key, String[] filter,String staff_id, String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sale_id,'')";
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
            field = "sale_stage ASC,assign_staff_name asc, next_time";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Sale> list = saleService.findAllSales(selectEntity);
        int num = saleService.getSaleNumber(selectEntity);
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
     * 更新销售表
     *
     * @param response
     * @param request
     * @param sale
     */
    @RequestMapping(value = "updateSale", method = RequestMethod.GET)
    public void updateSale(HttpServletResponse response, HttpServletRequest request, Sale sale) {
        JSONObject json = new JSONObject();
        int code = 100;
        int getsign;
        getsign=saleService.modifySale(sale);
        json.put("getsign",getsign);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findAllFollow", method = RequestMethod.GET)
    public void findAllFollow(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                              String field, String order, String sale_id) {
        String sql = "sale_id='" + sale_id+"'";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setSql(sql);
        selectEntity.setLimit(limit);
        if (field == null) {
            field = "follow_up_id";
            order = "desc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<FollowUp> list = saleService.findAllFollow(selectEntity);
        int num = saleService.getFollowNumber(selectEntity);
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

    //销售界面查询sale表
    @RequestMapping(value = "findAllSaleById", method = RequestMethod.GET)
    public void findAllSaleById(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                            String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sale_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and assign_staff_id = " + "'" +staff_id + "'" ;
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
            field = "sale_stage asc,next_time asc,time_load ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Sale> list = saleService.findAllSalesById(selectEntity);
        int num = saleService.getSaleNumberById(selectEntity);
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

    //销售界面邀约到店记录查询
    @RequestMapping(value = "findAllComeToShopSaleById", method = RequestMethod.GET)
    public void findAllComeToShopSaleById(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sale_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and assign_staff_id = " + "'" +staff_id + "' and (arrive_time is not null or is_coming='上访')" ;
        } else {
            key = "concat(concat('%"+ key +"%'))" + " and assign_staff_id = " + "'" +staff_id + "' and (arrive_time is not null or is_coming='上访')";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "arrive_time asc,time_load ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Sale> list = saleService.findAllComeToShopSaleById(selectEntity);
        int num = saleService.getAllComeToShopSaleNumberById(selectEntity);
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


    @RequestMapping(value = "findNotComeToShopSaleById", method = RequestMethod.GET)
    public void findNotComeToShopSaleById(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                              String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sale_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and assign_staff_id = " + "'" +staff_id + "' and arrive_time is not null" ;
        } else {
            key = "concat(concat('%"+ key +"%'))" + " and assign_staff_id = " + "'" +staff_id + "'and arrive_time is not null";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "arrive_time asc,time_load ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Sale> list = saleService.findNotComeToShopSaleById(selectEntity);
        int num = saleService.getNotComeToShopSaleNumberById(selectEntity);
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


    @RequestMapping(value = "findHaveComeToShopSaleById", method = RequestMethod.GET)
    public void findHaveComeToShopSaleById(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                          String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sale_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and assign_staff_id = " + "'" +staff_id + "' and  is_coming='上访' and sale_stage!='B-接受'" ;
        } else {
            key = "concat(concat('%"+ key +"%'))" + " and assign_staff_id = " + "'" +staff_id + "'and is_coming='上访' and sale_stage!='B-接受'";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "arrive_time asc,time_load ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Sale> list = saleService.findHaveComeToShopSaleById(selectEntity);
        int num = saleService.getHaveComeToShopSaleNumberById(selectEntity);
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


    @RequestMapping(value = "findHaveComeToShopSaleUnSignById", method = RequestMethod.GET)
    public void findHaveComeToShopSaleUnSignById(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                           String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(sale_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and assign_staff_id = " + "'" +staff_id + "' and  is_coming='上访' and sale_stage='B-接受' " ;
        } else {
            key = "concat(concat('%"+ key +"%'))" + " and assign_staff_id = " + "'" +staff_id + "'and is_coming='上访' and sale_stage='B-接受' ";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "arrive_time asc,time_load ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Sale> list = saleService.findHaveComeToShopSaleUnSignById(selectEntity);
        int num = saleService.getHaveComeToShopSaleUnSignNumberById(selectEntity);
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



















    /**
     * 跳转界面
     *
     * @param request
     * @param model
     * @param sale_id
     * @param jsp
     * @return
     */
    @RequestMapping(value = "gotoJsp", method = RequestMethod.GET)
    public String gotoJsp(HttpServletRequest request, Model model, String sale_id, String jsp) {
        model.addAttribute("sale", saleService.findSaleById(sale_id));
        return "pop/" + jsp;
    }

    @RequestMapping(value = "gotoFollow", method = RequestMethod.GET)
    public String gotoFollow(HttpServletRequest request, Model model, FollowUp followUp, String jsp) {
        model.addAttribute("follow", saleService.findLastFollowById(followUp));
        return "pop/" + jsp;
    }

    /**
     * 添加回访记录
     *
     * @param response
     * @param request
     * @param followUp
     */
    @RequestMapping(value = "addFollow", method = RequestMethod.POST)
    public void addFollow(HttpServletResponse response, HttpServletRequest request, FollowUp followUp) {
        JSONObject json = new JSONObject();
        int code = 100;
        String id = saleService.addFollow(followUp);
        json.put("code", code);
        json.put("id", id);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 添加到店回访记录
     *
     * @param response
     * @param request
     * @param followUp
     */
    @RequestMapping(value = "addComeToShopFollow", method = RequestMethod.POST)
    public void addComeToShopFollow(HttpServletResponse response, HttpServletRequest request, FollowUp followUp) {
        JSONObject json = new JSONObject();
        int code = 100;
        String id = saleService.addComeToShopFollow(followUp);
        json.put("code", code);
        json.put("id", id);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传证件图片 与一寸照
     *
     * @param response
     * @param request
     * @param followUp
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void upload(HttpServletResponse response, HttpServletRequest request, FollowUp followUp, String name) {
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");

        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    try {
                        myFileName = new String(myFileName.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 定义上传路径
                        try {
                            File file2 = new File(StaticValues.FOLLOW_SCREEN_DISK + followUp.getFollow_up_id());
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            String fileName = name + "." + myFileName.substring(myFileName.lastIndexOf(".") + 1);
                            String path = StaticValues.FOLLOW_SCREEN_DISK + followUp.getFollow_up_id() + "/" + fileName;
                            // 存文件
                            File localFile = new File(path);
                            file.transferTo(localFile);
                            if (name.compareTo("screen_image") == 0) {
                                followUp.setScreen_image(path);
                                saleService.modifyScreen_Image(followUp);
                            }
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
        json.put("code", 100);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
