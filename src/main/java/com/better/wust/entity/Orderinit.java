package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*初始订单 毛单---单纯收集了客户信息  并没有和客户确认*/
public class Orderinit {

    private String order_init_id;//毛单ID
    private String order_staff_id;//毛单的营销人员ID
    private String channel_id;//渠道ID
    private String channel_name;//渠道名称
    private String collect_name;
    private String collect_tel;

    private String customer_name;//客户名字
    private String customer_contact;//客户联系方式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entry_date;//毛单上所填时间
    private String entry_date_str;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entry_real;//毛单录入系统时间
    private String entry_real_str;
    private String State;//毛单状态  是否分配给了销售人员
    private String assign_staff_id;//处理毛单的销售人员id
    private String effective;//毛单状态
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date assign_time;//毛单分配给销售人员时间
    private String assign_time_str;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tel_time;//销售电话沟通日期
    private String tel_time_str;

    //列表所需
    private String order_staff_name;//营销人员姓名
    private String assign_staff_name;//销售人员姓名
    private String OnOffline;//毛单来源方式  线上or线下
    private String channel_type;//渠道类型
    private Integer campus_id;//校区ID
    private String campus_name;//校区姓名
    private Integer assign_campus_id;//毛单来源校区id
    private String assign_campus_name;//毛单来源校区名字

    private String weixin;

    private String marketing_id;
    private String marketing_name;

    private String to_shop;


    //12.12后
    private String stu_name;
    private int  stu_age;
    private String stu_school;
    private String address;



    @Override
    public String toString() {
        return "Orderinit{" +
                "order_init_id='" + order_init_id + '\'' +
                ", order_staff_id='" + order_staff_id + '\'' +
                ", channel_id='" + channel_id + '\'' +
                ", channel_name='" + channel_name + '\'' +
                ", collect_name='" + collect_name + '\'' +
                ", collect_tel='" + collect_tel + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_contact='" + customer_contact + '\'' +
                ", entry_date=" + entry_date +
                ", entry_real=" + entry_real +
                '}';
    }


    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getStu_age() {
        return stu_age;
    }

    public void setStu_age(int stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_school() {
        return stu_school;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTo_shop() {
        return to_shop;
    }

    public void setTo_shop(String to_shop) {
        this.to_shop = to_shop;
    }

    public String getMarketing_name() {
        return marketing_name;
    }

    public void setMarketing_name(String marketing_name) {
        this.marketing_name = marketing_name;
    }

    public String getMarketing_id() {
        return marketing_id;
    }

    public void setMarketing_id(String marketing_id) {
        this.marketing_id = marketing_id;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getOrder_init_id() {
        return order_init_id;
    }

    public void setOrder_init_id(String order_init_id) {
        this.order_init_id = order_init_id;
    }

    public String getOrder_staff_id() {
        return order_staff_id;
    }

    public void setOrder_staff_id(String order_staff_id) {
        this.order_staff_id = order_staff_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAssign_staff_id() {
        return assign_staff_id;
    }

    public void setAssign_staff_id(String assign_staff_id) {
        this.assign_staff_id = assign_staff_id;
    }

    public String getOrder_staff_name() {
        return order_staff_name;
    }

    public void setOrder_staff_name(String order_staff_name) {
        this.order_staff_name = order_staff_name;
    }

    public String getAssign_staff_name() {
        return assign_staff_name;
    }

    public void setAssign_staff_name(String assign_staff_name) {
        this.assign_staff_name = assign_staff_name;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public String getEntry_date_str() {
        if (entry_date != null) {
            entry_date_str = DateUtils.dateToString(entry_date, "yyyy-MM-dd");
        }
        return entry_date_str;
    }

    public void setEntry_date_str(String entry_date_str) {
        this.entry_date_str = entry_date_str;
    }

    public Date getEntry_real() {
        return entry_real;
    }

    public void setEntry_real(Date entry_real) {
        this.entry_real = entry_real;
    }

    public String getEntry_real_str() {
        if (entry_real != null) {
            entry_real_str = DateUtils.dateToString(entry_real, "yyyy-MM-dd HH:mm:ss");
        }
        return entry_real_str;
    }

    public void setEntry_real_str(String entry_real_str) {
        this.entry_real_str = entry_real_str;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getCollect_name() {
        return collect_name;
    }

    public void setCollect_name(String collect_name) {
        this.collect_name = collect_name;
    }

    public String getCollect_tel() {
        return collect_tel;
    }

    public void setCollect_tel(String collect_tel) {
        this.collect_tel = collect_tel;
    }

    public String getOnOffline() {
        return OnOffline;
    }

    public void setOnOffline(String onOffline) {
        OnOffline = onOffline;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public Date getAssign_time() {
        return assign_time;
    }

    public void setAssign_time(Date assign_time) {
        this.assign_time = assign_time;
    }

    public String getAssign_time_str() {
        if (assign_time != null) {
            assign_time_str = DateUtils.dateToString(assign_time, "yyyy-MM-dd HH:mm:ss");
        }
        return assign_time_str;
    }

    public void setAssign_time_str(String assign_time_str) {
        this.assign_time_str = assign_time_str;
    }

    public Date getTel_time() {
        return tel_time;
    }

    public void setTel_time(Date tel_time) {
        this.tel_time = tel_time;
    }

    public String getTel_time_str() {
        if (tel_time != null) {
            tel_time_str = DateUtils.dateToString(tel_time, "yyyy-MM-dd HH:mm:ss");
        }
        return tel_time_str;
    }

    public void setTel_time_str(String tel_time_str) {
        this.tel_time_str = tel_time_str;
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

    public Integer getAssign_campus_id() {
        return assign_campus_id;
    }

    public void setAssign_campus_id(Integer assign_campus_id) {
        this.assign_campus_id = assign_campus_id;
    }

    public String getAssign_campus_name() {
        return assign_campus_name;
    }

    public void setAssign_campus_name(String assign_campus_name) {
        this.assign_campus_name = assign_campus_name;
    }
}
