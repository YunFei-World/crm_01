package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*订单详情  订单---销售单更新后 有购课需求的客户进一步补充*/
public class SignSql {







    // 需要属性
    private String customer_name;//客户姓名
    private String customer_contact;//客户联系方式
    private String relation;//客户与学生关系
    private String stu_name;//学生姓名




    private String sign_id;//订单ID

    private String course_id;//课程ID
    private String course_name;//课程名称

    private Double final_price;//最终价格
    private Date sign_date;
    private Date estimate_time;
    private Date actual_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date load_time;
    private String load_time_str;
    private String load_time_str2;


    private String student_name;
    private String student_sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date student_birthday;
    private String student_birthday_str;
    private String student_phone;

    private Double reward_balance;//优惠
    private Double order_course_num;//购买课程原价


    private String student_id;//学生学号



    private String assign_staff_id;//销售人员ID
    private String assign_staff_name;//销售人员姓名
    private String campus_name;//校区名称
    private Integer campus_id;//校区ID


    private String remark;


    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getAssign_staff_id() {
        return assign_staff_id;
    }

    public void setAssign_staff_id(String assign_staff_id) {
        this.assign_staff_id = assign_staff_id;
    }

    public String getAssign_staff_name() {
        return assign_staff_name;
    }

    public void setAssign_staff_name(String assign_staff_name) {
        this.assign_staff_name = assign_staff_name;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Date getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(Date student_birthday) {
        this.student_birthday = student_birthday;
    }

    public String getStudent_birthday_str() {

        if (student_birthday != null) {
            student_birthday_str = DateUtils.dateToString(student_birthday, "yyyy-MM-dd");
        }

        return student_birthday_str;
    }

    public void setStudent_birthday_str(String student_birthday_str) {
        this.student_birthday_str = student_birthday_str;
    }


    public Date getLoad_time() {
        return load_time;
    }

    public void setLoad_time(Date load_time) {
        this.load_time = load_time;
    }

    public String getLoad_time_str() {
        if (load_time != null) {
            load_time_str = DateUtils.dateToString(load_time, "yyyy-MM-dd HH:mm:ss");
        }
        return load_time_str;

    }

    public void setLoad_time_str2(String load_time_str2) {
        this.load_time_str2 = load_time_str2;
    }


    public String getLoad_time_str2() {
        if (load_time != null) {
            load_time_str2 = DateUtils.dateToString(load_time, "yyyy-MM-dd");
        }
        return load_time_str2;

    }

    public void setLoad_time_str(String load_time_str) {
        this.load_time_str = load_time_str;
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

    public String getSign_id() {
        return sign_id;
    }

    public void setSign_id(String sign_id) {
        this.sign_id = sign_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public Double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(Double final_price) {
        this.final_price = final_price;
    }

    public Date getSign_date() {
        return sign_date;
    }

    public void setSign_date(Date sign_date) {
        this.sign_date = sign_date;
    }

    public Date getEstimate_time() {
        return estimate_time;
    }

    public void setEstimate_time(Date estimate_time) {
        this.estimate_time = estimate_time;
    }

    public Date getActual_time() {
        return actual_time;
    }

    public void setActual_time(Date actual_time) {
        this.actual_time = actual_time;
    }



    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public Double getReward_balance() {
        return reward_balance;
    }

    public void setReward_balance(Double reward_balance) {
        this.reward_balance = reward_balance;
    }

    public Double getOrder_course_num() {
        return order_course_num;
    }

    public void setOrder_course_num(Double order_course_num) {
        this.order_course_num = order_course_num;
    }
}
