package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SubjectTask {
    private Integer subject_id;
    private Integer campus_id;
    private String month;
    private Double subject_task;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date load_time;//提交时间
    private String load_time_str;

    private String subject_name;
    private String campus_name;

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getSubject_task() {
        return subject_task;
    }

    public void setSubject_task(Double subject_task) {
        this.subject_task = subject_task;
    }

    public Date getLoad_time() {
        return load_time;
    }

    public void setLoad_time(Date load_time) {
        this.load_time = load_time;
    }

    public String getLoad_time_str() {
        if(load_time != null){
            load_time_str = DateUtils.dateToString(load_time,"yyyy-MM-dd HH:mm:ss");
        }
        return load_time_str;
    }

    public void setLoad_time_str(String load_time_str) {
        this.load_time_str = load_time_str;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }
}
