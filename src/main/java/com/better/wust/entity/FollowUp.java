package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*回访记录*/
public class FollowUp {
    private String follow_up_id;//回访id
    private String sale_id;//销售单ID
    private String is_effective;//毛单是否有效
    private String contact_style;//与客户沟通方式
    private String judge_up;//是否接受继续了解课程产品
    private String staff_name;//销售姓名
    private String assign_staff_id;//销售ID
    private String sale_stage_up;//客户接受等级  A B C D  Y
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date next_time_up;//下次回访时间
    private String next_time_up_str;
    private String result;//回访结果记录
    private String screen_image;//回访过程截图

    private String contact_number;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time_load;//这次回访记录提交时间
    private String time_load_str;

    private String false_reason;
    private String other_remark;
    private String is_coming;

    private String other_reason;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrive_time;//这次回访记录提交时间
    private String arrive_time_str;


    public String getOther_reason() {
        return other_reason;
    }

    public void setOther_reason(String other_reason) {
        this.other_reason = other_reason;
    }

    public Date getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(Date arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getArrive_time_str() {

        if (arrive_time != null) {
            arrive_time_str = DateUtils.dateToString(arrive_time, "yyyy-MM-dd HH:mm:ss");
        }

        return arrive_time_str;
    }

    public void setArrive_time_str(String arrive_time_str) {
        this.arrive_time_str = arrive_time_str;
    }


    public String getIs_coming() {
        return is_coming;
    }

    public void setIs_coming(String is_coming) {
        this.is_coming = is_coming;
    }

    public String getFalse_reason() {
        return false_reason;
    }

    public void setFalse_reason(String false_reason) {
        this.false_reason = false_reason;
    }

    public String getOther_remark() {
        return other_remark;
    }

    public void setOther_remark(String other_remark) {
        this.other_remark = other_remark;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getFollow_up_id() {
        return follow_up_id;
    }

    public void setFollow_up_id(String follow_up_id) {
        this.follow_up_id = follow_up_id;
    }

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getIs_effective() {
        return is_effective;
    }

    public void setIs_effective(String is_effective) {
        this.is_effective = is_effective;
    }

    public String getContact_style() {
        return contact_style;
    }

    public void setContact_style(String contact_style) {
        this.contact_style = contact_style;
    }

    public String getJudge_up() {
        return judge_up;
    }

    public void setJudge_up(String judge_up) {
        this.judge_up = judge_up;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getSale_stage_up() {
        return sale_stage_up;
    }

    public void setSale_stage_up(String sale_stage_up) {
        this.sale_stage_up = sale_stage_up;
    }

    public Date getNext_time_up() {
        return next_time_up;
    }

    public void setNext_time_up(Date next_time_up) {
        this.next_time_up = next_time_up;
    }

    public String getNext_time_up_str() {
        if (next_time_up != null) {
            next_time_up_str = DateUtils.dateToString(next_time_up, "yyyy-MM-dd HH:mm:ss");
        }
        return next_time_up_str;
    }

    public void setNext_time_up_str(String next_time_up_str) {
        this.next_time_up_str = next_time_up_str;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScreen_image() {
        return screen_image;
    }

    public void setScreen_image(String screen_image) {
        this.screen_image = screen_image;
    }

    public Date getTime_load() {
        return time_load;
    }

    public void setTime_load(Date time_load) {
        this.time_load = time_load;
    }

    public String getTime_load_str() {
        if (time_load != null) {
            time_load_str = DateUtils.dateToString(time_load, "yyyy-MM-dd HH:mm:ss");
        }
        return time_load_str;
    }

    public void setTime_load_str(String time_load_str) {
        this.time_load_str = time_load_str;
    }

    public String getAssign_staff_id() {
        return assign_staff_id;
    }

    public void setAssign_staff_id(String assign_staff_id) {
        this.assign_staff_id = assign_staff_id;
    }
}
