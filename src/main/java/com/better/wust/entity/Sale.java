package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*销售单信息    销售订单---毛单接受后更新 对毛单的补充*/
public class Sale {

    private String sale_id;//订单ID
    private String order_init_id;//毛单ID
    private String relation;//客户与孩子关系
    private String stu_name;//学生姓名
    private Integer stu_age;//学生年纪
    private String stu_grade;//学生年级
    private String stu_school;//学生学校
    private String referrer;//
    private String judge;//是否接受继续了解课程产品
    private String course_need;//课程需求
    private String sale_stage;//客户接受等级  A B C D  Y
    private String address;//客户家庭住址
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date next_time;//下次回访时间
    private String next_time_str;
    private String false_reason;//客户拒绝课程原因
    private String other_reason;//客户选中其它因素时  输入   注：如果原因选中并为其它原因  则 other_reason==""


    private String other_remark;

    //列表所需
    private String customer_name;//客户姓名（家长姓名）
    private String customer_contact;//客户联系方式
    private String assign_staff_name;//销售人员姓名
    private String assign_staff_id;//销售人员ID
    private Integer campus_id;//校区ID
    private String campus_name;//校区名字



    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time_load;//这次回访记录提交时间
    private String time_load_str;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrive_time;//这次回访记录提交时间
    private String arrive_time_str;


    public String getOther_reason() {
        return other_reason;
    }

    public void setOther_reason(String other_reason) {
        this.other_reason = other_reason;
    }

    public Date getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(Date arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getArrive_time_str() {

        if (arrive_time != null) {
            arrive_time_str = DateUtils.dateToString(arrive_time, "yyyy-MM-dd HH:mm:ss");
        }

        return arrive_time_str;
    }

    public void setArrive_time_str(String arrive_time_str) {
        this.arrive_time_str = arrive_time_str;
    }

    private String is_coming;

    public String getIs_coming() {
        return is_coming;
    }

    public void setIs_coming(String is_coming) {
        this.is_coming = is_coming;
    }

    public Date getTime_load() {
        return time_load;
    }

    public void setTime_load(Date time_load) {
        this.time_load = time_load;
    }

    public String getTime_load_str() {
        if (time_load != null) {
            time_load_str = DateUtils.dateToString(time_load, "yyyy-MM-dd HH:mm:ss");
        }
        return time_load_str;

    }

    public void setTime_load_str(String time_load_str) {
        this.time_load_str = time_load_str;
    }

    public String getOther_remark() {
        return other_remark;
    }

    public void setOther_remark(String other_remark) {
        this.other_remark = other_remark;
    }

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getOrder_init_id() {
        return order_init_id;
    }

    public void setOrder_init_id(String order_init_id) {
        this.order_init_id = order_init_id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public Integer getStu_age() {
        return stu_age;
    }

    public void setStu_age(Integer stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_grade() {
        return stu_grade;
    }

    public void setStu_grade(String stu_grade) {
        this.stu_grade = stu_grade;
    }

    public String getStu_school() {
        return stu_school;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getCourse_need() {
        return course_need;
    }

    public void setCourse_need(String course_need) {
        this.course_need = course_need;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getAssign_staff_name() {
        return assign_staff_name;
    }

    public void setAssign_staff_name(String assign_staff_name) {
        this.assign_staff_name = assign_staff_name;
    }

    public String getSale_stage() {
        return sale_stage;
    }

    public void setSale_stage(String sale_stage) {
        this.sale_stage = sale_stage;
    }

    public String getAssign_staff_id() {
        return assign_staff_id;
    }

    public void setAssign_staff_id(String assign_staff_id) {
        this.assign_staff_id = assign_staff_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFalse_reason() {
        return false_reason;
    }

    public void setFalse_reason(String false_reason) {
        this.false_reason = false_reason;
    }

    public Date getNext_time() {
        return next_time;
    }

    public void setNext_time(Date next_time) {
        this.next_time = next_time;
    }

    public String getNext_time_str() {
        if (next_time != null) {
            next_time_str = DateUtils.dateToString(next_time, "yyyy-MM-dd HH:mm:ss");
        }
        return next_time_str;
    }

    public void setNext_time_str(String next_time_str) {
        this.next_time_str = next_time_str;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }
}
