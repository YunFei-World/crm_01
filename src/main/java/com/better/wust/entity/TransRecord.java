package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*转换毛单   将毛多过多的销售人员  分出一部分转给较少毛单的销售人员*/
public class TransRecord {
    private Integer trans_id;
    private String order_init_id;//毛单ID
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date trans_time;//毛单转换时间
    private String trans_time_str;
    private String staff_id;//得到毛单销售ID
    private String out_staff_id;//交出毛单ID

    //列表所需
    private String customer_name;//客户姓名
    private String customer_contact;//客户联系方式
    private String out_staff_name;//交出毛单销售
    private String in_staff_name;//得到毛单销售

    public Integer getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(Integer trans_id) {
        this.trans_id = trans_id;
    }

    public String getOrder_init_id() {
        return order_init_id;
    }

    public void setOrder_init_id(String order_init_id) {
        this.order_init_id = order_init_id;
    }

    public Date getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(Date trans_time) {
        this.trans_time = trans_time;
    }

    public String getTrans_time_str() {
        if(trans_time != null){
            trans_time_str = DateUtils.dateToString(trans_time,"yyyy-MM-dd HH:mm:ss");
        }
        return trans_time_str;
    }

    public void setTrans_time_str(String trans_time_str) {
        this.trans_time_str = trans_time_str;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getOut_staff_id() {
        return out_staff_id;
    }

    public void setOut_staff_id(String out_staff_id) {
        this.out_staff_id = out_staff_id;
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

    public String getOut_staff_name() {
        return out_staff_name;
    }

    public void setOut_staff_name(String out_staff_name) {
        this.out_staff_name = out_staff_name;
    }

    public String getIn_staff_name() {
        return in_staff_name;
    }

    public void setIn_staff_name(String in_staff_name) {
        this.in_staff_name = in_staff_name;
    }
}
