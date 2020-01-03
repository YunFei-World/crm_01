package com.better.wust.entity;

/*员工信息表*/
public class Staff {
    private String staff_id;//员工ID
    private String password;//密码
    private String staff_name;//员工名字
    private String staff_depart;//员工部门
    private String staff_post;//员工职位
    private String power;//员工登录界面
    private Integer campus_id;//员工所属校区ID
    private String campus_name;//员工所属校区

    private String staff_contact;
    private String staff_weixin;
    private String staff_email;


    public String getStaff_contact() {
        return staff_contact;
    }

    public void setStaff_contact(String staff_contact) {
        this.staff_contact = staff_contact;
    }

    public String getStaff_weixin() {
        return staff_weixin;
    }

    public void setStaff_weixin(String staff_weixin) {
        this.staff_weixin = staff_weixin;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_depart() {
        return staff_depart;
    }

    public void setStaff_depart(String staff_depart) {
        this.staff_depart = staff_depart;
    }

    public String getStaff_post() {
        return staff_post;
    }

    public void setStaff_post(String staff_post) {
        this.staff_post = staff_post;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
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
}
