package com.better.wust.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Student {
    private int id;
    private String student_id;
    private String user_password;
    private String student_name;
    private String course_id;
    private Date student_birthday;

    private String student_certificates_type;
    private String student_certificates_number;

    private String student_sex;
    private String student_address;
    private String student_phone;
    private String student_email;
    private String student_education;
    private String student_idcard_picture_one;
    private String student_idcard_picture_tow;
    private String student_person_picture;

    private Integer student_state;
    private Integer campus_id;

    private String student_remark;
    private String student_type;

    private Timestamp create_time;
    private Timestamp update_time;

    private String contact_name_one;
    private String contact_tel_one;
    private String contact_name_two;
    private String contact_tel_two;

    private Double real_balance;
    private Double reward_balance;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public Date getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(Date student_birthday) {
        this.student_birthday = student_birthday;
    }

    public String getStudent_certificates_type() {
        return student_certificates_type;
    }

    public void setStudent_certificates_type(String student_certificates_type) {
        this.student_certificates_type = student_certificates_type;
    }

    public String getStudent_certificates_number() {
        return student_certificates_number;
    }

    public void setStudent_certificates_number(String student_certificates_number) {
        this.student_certificates_number = student_certificates_number;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_education() {
        return student_education;
    }

    public void setStudent_education(String student_education) {
        this.student_education = student_education;
    }

    public String getStudent_idcard_picture_one() {
        return student_idcard_picture_one;
    }

    public void setStudent_idcard_picture_one(String student_idcard_picture_one) {
        this.student_idcard_picture_one = student_idcard_picture_one;
    }

    public String getStudent_idcard_picture_tow() {
        return student_idcard_picture_tow;
    }

    public void setStudent_idcard_picture_tow(String student_idcard_picture_tow) {
        this.student_idcard_picture_tow = student_idcard_picture_tow;
    }

    public String getStudent_person_picture() {
        return student_person_picture;
    }

    public void setStudent_person_picture(String student_person_picture) {
        this.student_person_picture = student_person_picture;
    }

    public Integer getStudent_state() {
        return student_state;
    }

    public void setStudent_state(Integer student_state) {
        this.student_state = student_state;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }

    public String getStudent_remark() {
        return student_remark;
    }

    public void setStudent_remark(String student_remark) {
        this.student_remark = student_remark;
    }

    public String getStudent_type() {
        return student_type;
    }

    public void setStudent_type(String student_type) {
        this.student_type = student_type;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getContact_name_one() {
        return contact_name_one;
    }

    public void setContact_name_one(String contact_name_one) {
        this.contact_name_one = contact_name_one;
    }

    public String getContact_tel_one() {
        return contact_tel_one;
    }

    public void setContact_tel_one(String contact_tel_one) {
        this.contact_tel_one = contact_tel_one;
    }

    public String getContact_name_two() {
        return contact_name_two;
    }

    public void setContact_name_two(String contact_name_two) {
        this.contact_name_two = contact_name_two;
    }

    public String getContact_tel_two() {
        return contact_tel_two;
    }

    public void setContact_tel_two(String contact_tel_two) {
        this.contact_tel_two = contact_tel_two;
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
}
