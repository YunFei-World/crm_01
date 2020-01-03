package com.better.wust.entity;


import java.sql.Timestamp;

/*课程类别与名称*/
public class SubjectCourse {

    private Integer course_id;//课程ID
    private String course_name;//课程名称
    private Integer course_rank;

    private Integer subject_id;
    private String subject_name;//课程类别
    private Integer subject_rank;

    private Timestamp CREATE_TIME;
    private Timestamp UPDATE_TIME;

    private String REMARK;
    private String INTRO;

    private Integer STATE;
    private double UNIT_PRICE;
    private Integer version;
    private Integer lessonNum;
    private double totalPrice;

    private Integer chargetype;
    private String campusid;
    private Integer campusnum;

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getCourse_rank() {
        return course_rank;
    }

    public void setCourse_rank(Integer course_rank) {
        this.course_rank = course_rank;
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

    public Integer getSubject_rank() {
        return subject_rank;
    }

    public void setSubject_rank(Integer subject_rank) {
        this.subject_rank = subject_rank;
    }

    public Timestamp getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Timestamp CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public Timestamp getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(Timestamp UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getINTRO() {
        return INTRO;
    }

    public void setINTRO(String INTRO) {
        this.INTRO = INTRO;
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public double getUNIT_PRICE() {
        return UNIT_PRICE;
    }

    public void setUNIT_PRICE(double UNIT_PRICE) {
        this.UNIT_PRICE = UNIT_PRICE;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getChargetype() {
        return chargetype;
    }

    public void setChargetype(Integer chargetype) {
        this.chargetype = chargetype;
    }

    public String getCampusid() {
        return campusid;
    }

    public void setCampusid(String campusid) {
        this.campusid = campusid;
    }

    public Integer getCampusnum() {
        return campusnum;
    }

    public void setCampusnum(Integer campusnum) {
        this.campusnum = campusnum;
    }
}
