package com.better.wust.entity;

public class SubjectStatistics {
    private Integer subject_id;
    private Integer campus_id;
    private Double subject_task_money;
    private Double subject_sale_money;
    private Double subject_finish_proportion;
    private int subject_signup_num;

    private String time_start;
    private String time_end;


    //list添加

    private String campus_name;
    private String subject_name;


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

    public Double getSubject_task_money() {
        return subject_task_money;
    }

    public void setSubject_task_money(Double subject_task_money) {
        this.subject_task_money = subject_task_money;
    }

    public Double getSubject_sale_money() {
        return subject_sale_money;
    }

    public void setSubject_sale_money(Double subject_sale_money) {
        this.subject_sale_money = subject_sale_money;
    }

    public Double getSubject_finish_proportion() {
        return subject_finish_proportion;
    }

    public void setSubject_finish_proportion(Double subject_finish_proportion) {
        this.subject_finish_proportion = subject_finish_proportion;
    }

    public int getSubject_signup_num() {
        return subject_signup_num;
    }

    public void setSubject_signup_num(int subject_signup_num) {
        this.subject_signup_num = subject_signup_num;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
}
