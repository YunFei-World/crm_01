package com.better.wust.controller;

import com.better.wust.entity.*;
import com.better.wust.service.StaffService;
import com.better.wust.service.SubjectCourseService;
import com.better.wust.tools.DigitalUtils;
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
import java.util.List;

@Controller
@RequestMapping("staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private SubjectCourseService subjectCourseService;

    @RequestMapping(value = "findAllStaffs", method = RequestMethod.GET)
    public void findAllStaffs(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                              String field, String order, String key, String[] filter, String staff_id, String campus_id,String staff_depart) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(staff_id,'')";
        }
        if(campus_id == "") {
            if (key == null) {
                if (staff_depart!=""){
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')   and  staff_depart ='"+ staff_depart+"' " ;
                }else{
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and  staff_depart in ('营销部','销售部','管理员')";
                }
            } else {
                if (staff_depart!=""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')and  staff_depart ='"+ staff_depart+"'";
                } else{
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and  staff_depart in ('营销部','销售部','管理员')";
                }
            }
        } else {
            if (key == null) {
                if (staff_depart!=""){
                    key = "concat(concat('%%'))" + " and campus_id = '" + campus_id + "' and  staff_depart ='"+ staff_depart+"' ";
                }else{
                    key = "concat(concat('%%'))" + " and campus_id = '" + campus_id + "'and  staff_depart in ('营销部','销售部','管理员')";
                }

            } else {
                if (staff_depart!=""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id = '" + campus_id + "' and  staff_depart ='"+ staff_depart+"' ";
                }else {
                    key = "concat(concat('%" + key + "%'))" + " and campus_id = '" + campus_id + "' and  staff_depart in ('营销部','销售部','管理员')";
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
            field = "staff_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Staff> list = staffService.findAllStaffs(selectEntity);
        int num = staffService.getStaffNumber(selectEntity);
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

    //通过员工id查找  对应员工管理的所有校区
    @RequestMapping(value = "findAllCampusById", method = RequestMethod.GET)
    public  void findAllCampusById(HttpServletResponse response, HttpServletRequest request,String staff_id,String campus_id) {
        JSONObject json = new JSONObject();
        int code = 0;
        response.setCharacterEncoding("UTF-8");
        if(campus_id == null){
            campus_id = "";
        }
        List<Staff> list = staffService.findAllCampusById(staff_id,campus_id);


        JSONArray data = JSONArray.fromObject(list);

        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    public void addStaff(HttpServletResponse response, HttpServletRequest request, Staff staffNew) {
        JSONObject json = new JSONObject();
        int code = 100;
        String id = "";
        id = staffService.addStaff(staffNew);
        json.put("id", id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新职员基本信息
     *
     * @param response
     * @param request
     * @param staffBase
     */
    @RequestMapping(value = "updateStaff", method = RequestMethod.POST)
    public void updateStaffBase(HttpServletResponse response, HttpServletRequest request, Staff staffBase) {
        JSONObject json = new JSONObject();
        int code = 100;
        staffService.modifyStaff(staffBase);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除员工
     *
     * @param response
     * @param request
     * @param staff_id
     */
    @RequestMapping(value = "deleteStaff", method = RequestMethod.POST)
    public void deleteStaff(HttpServletResponse response, HttpServletRequest request, String staff_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        try {
            //判断渠道id下是否还有活动  有活动则禁止其删除
            staffService.deleteStaff(staff_id);
        } catch (Exception e) {
            code = 101;
            e.printStackTrace();

        }

        json.put("code", code);
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
     * @param id
     * @param jsp
     * @return
     */
    @RequestMapping(value = "gotoJsp", method = RequestMethod.GET)
    public String gotoJsp(HttpServletRequest request, Model model, String id, String jsp,String campus_id) {
        model.addAttribute("campus_id", campus_id);
        model.addAttribute("staff1", staffService.findStaffById(id));
        return "pop/" + jsp;
    }

    @RequestMapping(value = "gotoSaleTask", method = RequestMethod.GET)
    public String gotoSaleTask(HttpServletRequest request, Model model, String jsp,String campus_id) {
        model.addAttribute("task_campus_id", campus_id);
        return "pop/" + jsp;
    }


    //查询某一个员工的所有  月销售任务
    @RequestMapping(value = "getSaleTaskById", method = RequestMethod.GET)
    public void getSaleTaskById(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                                String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(month,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and staff_id = " + "'" + staff_id + "'";
        } else {
            key = "concat(concat('%" + key + "%'))" + " and staff_id = " + "'" + staff_id + "'";
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
        List<SaleTask> list = staffService.getSaleTaskById(selectEntity);
        int num = staffService.getSaleTaskByIdNumber(selectEntity);
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




    /**
     * 更新职员基本信息
     *
     * @param response
     * @param request
     */
   //查询所有销售员工
    @RequestMapping(value = "findAllSaleStaff", method = RequestMethod.GET)
    public void findAllSaleStaff(HttpServletResponse response, HttpServletRequest request,String staff_id,String campus_id) {
        JSONObject json = new JSONObject();
        int code = 0;
        response.setCharacterEncoding("UTF-8");
        List<Staff> list = staffService.findAllSaleStaffs(staff_id,campus_id);
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //给选定员工分配销售任务
    @RequestMapping(value = "addSaleTask", method = RequestMethod.GET)
    public void addSaleTask(HttpServletResponse response, HttpServletRequest request, SaleTask saleTask, String all_staff) {
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");
        int code = 100;
        String staff_name = "";
        String[] ids=all_staff.split(",");
        for (String staff_id : ids) {
            SaleTask saleTask1 = staffService.checkedTask(staff_id, saleTask.getMonth());
            if (saleTask1 == null) {
                saleTask.setStaff_id(staff_id);
                staffService.addSaleTask(saleTask);
            } else {
                code = 101;
                staff_name = saleTask1.getStaff_name();
                break;
            }
        }
        json.put("code", code);
        json.put("staff_name", staff_name);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //查询所有校区员工的  所有 月销售任务
    @RequestMapping(value = "getAllSaleTask", method = RequestMethod.GET)
    public void getAllSaleTask(HttpServletRequest request, HttpServletResponse response, int page, int limit,
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
            field = "month desc, staff_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<SaleTask> list = staffService.getAllSaleTask(selectEntity);
        int num = staffService.getAllSaleTaskNumber(selectEntity);
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

    @RequestMapping(value = "updateSaleTask", method = RequestMethod.POST)
    public void updateSaleTask(HttpServletResponse response, HttpServletRequest request, SaleTask saleTask) {
        JSONObject json = new JSONObject();
        int code = 100;
        staffService.modifySaleTask(saleTask);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //----------------------------------------校区任务------------------------------------------
    //添加校区销售任务
    @RequestMapping(value = "insertSaleTaskSubject", method = RequestMethod.GET)
    public void insertSaleTaskSubject(HttpServletResponse response, HttpServletRequest request, SubjectTask subjectTask , Integer ids[]) {
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");
        int code =  staffService.insertSaleTaskSubject(ids,subjectTask);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "gotoSaleTaskCampus", method = RequestMethod.GET)
    public String gotoSaleTaskCampus(HttpServletRequest request, Model model, String jsp,String campus_id) {
        model.addAttribute("campus_task_campus_id", campus_id);
        return "pop/" + jsp;
    }


    //课程 类别和课程  用于校区销售任务分配
    @RequestMapping(value = "findAllSubject", method = RequestMethod.GET)
    public void findAllSubject(HttpServletResponse response, HttpServletRequest request) {
        JSONObject json = new JSONObject();
        int code = 0;
        response.setCharacterEncoding("UTF-8");
        List<Subject> list = subjectCourseService.findAllSubject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@RequestMapping(value = "findAllCourse", method = RequestMethod.GET)
    public void findAllCourse(HttpServletResponse response, HttpServletRequest request, String subject_id,String campus_id) {
        JSONObject json = new JSONObject();
        int code = 0;
        response.setCharacterEncoding("UTF-8");
        List<SubjectCourse> list = subjectCourseService.findAllCourses(subject_id,campus_id);
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



    //科目任务
    @RequestMapping(value = "findAllSaleTaskSubjectList", method = RequestMethod.GET)
    public void findAllSaleTaskSubjectList(HttpServletRequest request, HttpServletResponse response, int page, int limit,
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
            field = "campus_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<SubjectTask> list = staffService.findAllSaleTaskSubjectList(selectEntity);
        int num = staffService.getAllSaleTaskSubjectNumber(selectEntity);
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

    @RequestMapping(value = "updateSaleTaskCampus", method = RequestMethod.POST)
    public void updateSaleTaskCampus(HttpServletResponse response, HttpServletRequest request, SubjectTask subjectTask) {
        JSONObject json = new JSONObject();
        int code = 100;
        staffService.updateSaleTaskCampus(subjectTask);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 更新自己基本信息
     *
     * @param response
     * @param request
     * @param staff
     */
    @RequestMapping(value = "updateStaffByMyself", method = RequestMethod.GET)
    public void updateStaffByMyself(HttpServletResponse response, HttpServletRequest request, Staff staff) {
        JSONObject json = new JSONObject();
        int code = 100;
        Staff newstaff=staffService.updateStaffByMyself(staff);
        request.getSession().setAttribute("staff", newstaff);
        json.put("newstaff",newstaff);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @RequestMapping(value = "checkOldPwd", method = RequestMethod.POST)
    public void checkOldPwd(HttpServletResponse response, HttpServletRequest request, String  oldpwd,String staff_id) {
        JSONObject json = new JSONObject();
        int code=staffService.checkOldPwd(staff_id,oldpwd);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "updateStaffOwnPassword", method = RequestMethod.GET)
    public void updateStaffOwnPassword(HttpServletResponse response, HttpServletRequest request, String staff_id,String newpwd) {
        JSONObject json = new JSONObject();
        int code = 100;
        staffService.updateStaffOwnPassword(staff_id,newpwd);

        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
