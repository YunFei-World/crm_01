package com.better.wust.entity;

public class SaleReasonStatistics {
    private Integer campus_id;
    private String campus_name;
    private String sale_stage;
    private String false_reason;
    private Integer reason_count;
    private Integer reason_sum_count;
    private Double proportion;
    private String time_start;
    private String time_end;


    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public String getSale_stage() {
        return sale_stage;
    }

    public void setSale_stage(String sale_stage) {
        this.sale_stage = sale_stage;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }

    public String getFalse_reason() {
        return false_reason;
    }

    public void setFalse_reason(String false_reason) {
        this.false_reason = false_reason;
    }

    public Integer getReason_count() {
        return reason_count;
    }

    public void setReason_count(Integer reason_count) {
        this.reason_count = reason_count;
    }

    public Integer getReason_sum_count() {
        return reason_sum_count;
    }

    public void setReason_sum_count(Integer reason_sum_count) {
        this.reason_sum_count = reason_sum_count;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
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
}
