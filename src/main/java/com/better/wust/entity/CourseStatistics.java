package com.better.wust.entity;

public class CourseStatistics {
    private Integer course_id;
    private Integer subject_id;
    private Integer campus_id;
    private double course_task_money;
    private double course_sale_money;
    private double course_finish_proportion;
    private int course_signup_num;

    private String time_start;
    private String time_end;


    //list添加
    private String course_name;
    private String campus_name;
    private String subject_name;

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

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

    public double getCourse_task_money() {
        return course_task_money;
    }

    public void setCourse_task_money(double course_task_money) {
        this.course_task_money = course_task_money;
    }

    public double getCourse_sale_money() {
        return course_sale_money;
    }

    public void setCourse_sale_money(double course_sale_money) {
        this.course_sale_money = course_sale_money;
    }

    public double getCourse_finish_proportion() {
        return course_finish_proportion;
    }

    public void setCourse_finish_proportion(double course_finish_proportion) {
        this.course_finish_proportion = course_finish_proportion;
    }

    public int getCourse_signup_num() {
        return course_signup_num;
    }

    public void setCourse_signup_num(int course_signup_num) {
        this.course_signup_num = course_signup_num;
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

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
}
