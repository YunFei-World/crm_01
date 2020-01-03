package com.better.wust.entity;

public class SaleOneYearFirst { //一年销售数据统计分析
    //销售数据
    private String month;//2019-10
    private String month_str;
    private Integer campus_id;
    private String campus_name;
    private Double target_sale_money;
    private Double actual_sale_money;
    private Double proportion_sale_money;


    private Double proportion_sign_up;  //报名/实际咨询人数
    private Integer target_initorder_num;
    private Integer actual_initorder_num;
    private Integer sign_up_num;
    private Double average_sale_money;


    private Integer refund_num;
    private Double refund_money;
    private Double proportion_refund;


    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public String getMonth_str() {
        return month_str;
    }

    public void setMonth_str(String month_str) {
        this.month_str = month_str;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getTarget_sale_money() {
        return target_sale_money;
    }

    public void setTarget_sale_money(Double target_sale_money) {
        this.target_sale_money = target_sale_money;
    }

    public Double getActual_sale_money() {
        return actual_sale_money;
    }

    public void setActual_sale_money(Double actual_sale_money) {
        this.actual_sale_money = actual_sale_money;
    }

    public Double getProportion_sale_money() {
        return proportion_sale_money;
    }

    public void setProportion_sale_money(Double proportion_sale_money) {
        this.proportion_sale_money = proportion_sale_money;
    }

    public Double getProportion_sign_up() {
        return proportion_sign_up;
    }

    public void setProportion_sign_up(Double proportion_sign_up) {
        this.proportion_sign_up = proportion_sign_up;
    }

    public Integer getTarget_initorder_num() {
        return target_initorder_num;
    }

    public void setTarget_initorder_num(Integer target_initorder_num) {
        this.target_initorder_num = target_initorder_num;
    }

    public Integer getActual_initorder_num() {
        return actual_initorder_num;
    }

    public void setActual_initorder_num(Integer actual_initorder_num) {
        this.actual_initorder_num = actual_initorder_num;
    }

    public Integer getSign_up_num() {
        return sign_up_num;
    }

    public void setSign_up_num(Integer sign_up_num) {
        this.sign_up_num = sign_up_num;
    }

    public Double getAverage_sale_money() {
        return average_sale_money;
    }

    public void setAverage_sale_money(Double average_sale_money) {
        this.average_sale_money = average_sale_money;
    }

    public Integer getRefund_num() {
        return refund_num;
    }

    public void setRefund_num(Integer refund_num) {
        this.refund_num = refund_num;
    }

    public Double getRefund_money() {
        return refund_money;
    }

    public void setRefund_money(Double refund_money) {
        this.refund_money = refund_money;
    }

    public Double getProportion_refund() {
        return proportion_refund;
    }

    public void setProportion_refund(Double proportion_refund) {
        this.proportion_refund = proportion_refund;
    }
}
