package com.better.wust.entity;

public class Campus {
    private int campus_id;
    private String campus_name;
    private String campus_addr;
    private int state;
    private int president_id;
    private String  tel;
    private int jwuser_id;
    private int kcuser_id;
    private int perser_id;

    private int limit_ip;
    private int full_sign;
    private int part_sign;

    private int campus_type;

    private String campus_picture_one;
    private String campus_picture_two;
    private String campus_picture_three;

    private double lat;
    private double lng;
    private double cover;

    private String president_name;
    private String president_email;


    public String getPresident_name() {
        return president_name;
    }

    public void setPresident_name(String president_name) {
        this.president_name = president_name;
    }

    public String getPresident_email() {
        return president_email;
    }

    public void setPresident_email(String president_email) {
        this.president_email = president_email;
    }

    public int getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(int campus_id) {
        this.campus_id = campus_id;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public String getCampus_addr() {
        return campus_addr;
    }

    public void setCampus_addr(String campus_addr) {
        this.campus_addr = campus_addr;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPresident_id() {
        return president_id;
    }

    public void setPresident_id(int president_id) {
        this.president_id = president_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getJwuser_id() {
        return jwuser_id;
    }

    public void setJwuser_id(int jwuser_id) {
        this.jwuser_id = jwuser_id;
    }

    public int getKcuser_id() {
        return kcuser_id;
    }

    public void setKcuser_id(int kcuser_id) {
        this.kcuser_id = kcuser_id;
    }

    public int getPerser_id() {
        return perser_id;
    }

    public void setPerser_id(int perser_id) {
        this.perser_id = perser_id;
    }

    public int getLimit_ip() {
        return limit_ip;
    }

    public void setLimit_ip(int limit_ip) {
        this.limit_ip = limit_ip;
    }

    public int getFull_sign() {
        return full_sign;
    }

    public void setFull_sign(int full_sign) {
        this.full_sign = full_sign;
    }

    public int getPart_sign() {
        return part_sign;
    }

    public void setPart_sign(int part_sign) {
        this.part_sign = part_sign;
    }

    public int getCampus_type() {
        return campus_type;
    }

    public void setCampus_type(int campus_type) {
        this.campus_type = campus_type;
    }

    public String getCampus_picture_one() {
        return campus_picture_one;
    }

    public void setCampus_picture_one(String campus_picture_one) {
        this.campus_picture_one = campus_picture_one;
    }

    public String getCampus_picture_two() {
        return campus_picture_two;
    }

    public void setCampus_picture_two(String campus_picture_two) {
        this.campus_picture_two = campus_picture_two;
    }

    public String getCampus_picture_three() {
        return campus_picture_three;
    }

    public void setCampus_picture_three(String campus_picture_three) {
        this.campus_picture_three = campus_picture_three;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getCover() {
        return cover;
    }

    public void setCover(double cover) {
        this.cover = cover;
    }
}
