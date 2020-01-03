package com.better.wust.entity;


import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SignCourse {

    private Integer id;
    private String sign_id;
    private Integer course_id;
    private String student_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    private String create_time_str;

    private String course_name;
    private Double unit_price;
    private Integer lessonNum;
    private Double totalPrice;
    private Double chargetype;


    private Integer subject_id;
    private String subject_name;

    private Integer campus_id;
    private String campus_name;
    private Double deal_unit_price;
    private Double deal_price;

    private Double reward_balance;

    public Double getReward_balance() {
        return reward_balance;
    }

    public void setReward_balance(Double reward_balance) {
        this.reward_balance = reward_balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSign_id() {
        return sign_id;
    }

    public void setSign_id(String sign_id) {
        this.sign_id = sign_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getChargetype() {
        return chargetype;
    }

    public void setChargetype(Double chargetype) {
        this.chargetype = chargetype;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
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

    public Double getDeal_unit_price() {
        return deal_unit_price;
    }

    public void setDeal_unit_price(Double deal_unit_price) {
        this.deal_unit_price = deal_unit_price;
    }

    public Double getDeal_price() {
        return deal_price;
    }

    public void setDeal_price(Double deal_price) {
        this.deal_price = deal_price;
    }

    public String getCreate_time_str() {
        if (create_time != null) {
            create_time_str = DateUtils.dateToString(create_time, "yyyy-MM-dd HH:mm:ss");
        }
        return create_time_str;
    }

    public void setCreate_time_str(String create_time_str) {
        this.create_time_str = create_time_str;
    }
}
