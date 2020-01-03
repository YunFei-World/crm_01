package com.better.wust.entity;


import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentClass {

    private Integer id;
    private Integer student_id;
    private Integer course_id;
    private Integer is_retire;
    private Integer is_placement;
    private Integer order_course_num;
    private Integer remain_course_num;
    private Double actual_price;
    private Double deal_price;
    private Double deal_unit_price;
    private Double real_balance;
    private Double reward_balance;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_loadtime;
    private String update_loadtime_str;


    private String student_name;
    private String course_name;
    private String campus_name;

    private Integer transfer_campus_id;
    private String transfer_campus_name;


    public String getTransfer_campus_name() {
        return transfer_campus_name;
    }

    public void setTransfer_campus_name(String transfer_campus_name) {
        this.transfer_campus_name = transfer_campus_name;
    }

    public Integer getTransfer_campus_id() {
        return transfer_campus_id;
    }

    public void setTransfer_campus_id(Integer transfer_campus_id) {
        this.transfer_campus_id = transfer_campus_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getIs_retire() {
        return is_retire;
    }

    public void setIs_retire(Integer is_retire) {
        this.is_retire = is_retire;
    }

    public Integer getIs_placement() {
        return is_placement;
    }

    public void setIs_placement(Integer is_placement) {
        this.is_placement = is_placement;
    }

    public Integer getOrder_course_num() {
        return order_course_num;
    }

    public void setOrder_course_num(Integer order_course_num) {
        this.order_course_num = order_course_num;
    }

    public Integer getRemain_course_num() {
        return remain_course_num;
    }

    public void setRemain_course_num(Integer remain_course_num) {
        this.remain_course_num = remain_course_num;
    }

    public Double getActual_price() {
        return actual_price;
    }

    public void setActual_price(Double actual_price) {
        this.actual_price = actual_price;
    }

    public Double getDeal_price() {
        return deal_price;
    }

    public void setDeal_price(Double deal_price) {
        this.deal_price = deal_price;
    }

    public Double getDeal_unit_price() {
        return deal_unit_price;
    }

    public void setDeal_unit_price(Double deal_unit_price) {
        this.deal_unit_price = deal_unit_price;
    }

    public Double getReal_balance() {
        return real_balance;
    }

    public void setReal_balance(Double real_balance) {
        this.real_balance = real_balance;
    }

    public Double getReward_balance() {
        return reward_balance;
    }

    public void setReward_balance(Double reward_balance) {
        this.reward_balance = reward_balance;
    }

    public Date getUpdate_loadtime() {
        return update_loadtime;
    }

    public void setUpdate_loadtime(Date update_loadtime) {
        this.update_loadtime = update_loadtime;
    }

    public String getUpdate_loadtime_str() {
        if (update_loadtime != null) {
            update_loadtime_str = DateUtils.dateToString(update_loadtime, "yyyy-MM-dd HH:mm:ss");
        }
        return update_loadtime_str;
    }

    public void setUpdate_loadtime_str(String update_loadtime_str) {
        this.update_loadtime_str = update_loadtime_str;
    }
}
