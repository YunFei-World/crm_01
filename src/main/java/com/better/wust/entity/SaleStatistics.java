package com.better.wust.entity;
/*校区-销售单月统计   -- 接受（A B C D Y）   待定   拒绝*/
public class SaleStatistics {

    private String statistics_month;//月份

    private String judge_up;//接受与否

    private Integer count;//数量

    private String campus_name;//校区名称

    //my
    private Integer campus_id;
    private String sale_stage;//等级判断A B C D Y
    private Integer stage_count;
    private Integer sum_count;
    private Double proportion;
    private String time_start;
    private String time_end;




    public String getSale_stage() {
        return sale_stage;
    }

    public void setSale_stage(String sale_stage) {
        this.sale_stage = sale_stage;
    }

    public Integer getStage_count() {
        return stage_count;
    }

    public void setStage_count(Integer stage_count) {
        this.stage_count = stage_count;
    }

    public Integer getSum_count() {
        return sum_count;
    }

    public void setSum_count(Integer sum_count) {
        this.sum_count = sum_count;
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

    public String getStatistics_month() {
        return statistics_month;
    }

    public void setStatistics_month(String statistics_month) {
        this.statistics_month = statistics_month;
    }

    public String getJudge_up() {
        return judge_up;
    }

    public void setJudge_up(String judge_up) {
        this.judge_up = judge_up;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
