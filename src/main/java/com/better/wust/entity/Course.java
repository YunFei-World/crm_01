package com.better.wust.entity;


import java.sql.Timestamp;

public class Course {
    private int Id;
    private String COURSE_NAME;
    private Timestamp CREATE_TIME;
    private Timestamp UPDATE_TIME;
    private String REMARK;
    private String INTRO;
    private int STATE;
    private int SUBJECT_ID;
    private double UNIT_PRICE;
    private int version;
    private int lessonNum;
    private double totalPrice;
    private int rank;
    private int chargetype;
    private String campusid;
    private int campusnum;




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCOURSE_NAME() {
        return COURSE_NAME;
    }

    public void setCOURSE_NAME(String COURSE_NAME) {
        this.COURSE_NAME = COURSE_NAME;
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

    public int getSTATE() {
        return STATE;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }

    public int getSUBJECT_ID() {
        return SUBJECT_ID;
    }

    public void setSUBJECT_ID(int SUBJECT_ID) {
        this.SUBJECT_ID = SUBJECT_ID;
    }

    public double getUNIT_PRICE() {
        return UNIT_PRICE;
    }

    public void setUNIT_PRICE(double UNIT_PRICE) {
        this.UNIT_PRICE = UNIT_PRICE;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(int lessonNum) {
        this.lessonNum = lessonNum;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getChargetype() {
        return chargetype;
    }

    public void setChargetype(int chargetype) {
        this.chargetype = chargetype;
    }

    public String getCampusid() {
        return campusid;
    }

    public void setCampusid(String campusid) {
        this.campusid = campusid;
    }

    public int getCampusnum() {
        return campusnum;
    }

    public void setCampusnum(int campusnum) {
        this.campusnum = campusnum;
    }
}
