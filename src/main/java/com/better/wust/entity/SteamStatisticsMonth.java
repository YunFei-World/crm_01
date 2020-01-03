package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*校区每月销售统计*/
public class SteamStatisticsMonth {

    private String month;
    private String subject_name;//课程类别
    private Integer subject_id;
    private Integer course_id;
    private String course_name;//课程名称
    private Integer course_task;//课程销量金额目标
    private Integer course_task_actual;//课程出售实际金额
    private String finish_ratio;//目标与实际的比率
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date load_time;//提交时间
    private String load_time_str;

    //需要的属性
    private String staff_id;//员工id
    private Integer campus_id;//校区ID
    private String campus_name;//校区名字
    private String campusId;//


    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getCourse_task() {
        return course_task;
    }

    public void setCourse_task(Integer course_task) {
        this.course_task = course_task;
    }

    public Integer getCourse_task_actual() {
        return course_task_actual;
    }

    public void setCourse_task_actual(Integer course_task_actual) {
        this.course_task_actual = course_task_actual;
    }

    public String getFinish_ratio() {
        return finish_ratio;
    }

    public void setFinish_ratio(String finish_ratio) {
        this.finish_ratio = finish_ratio;
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

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
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

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }
}
