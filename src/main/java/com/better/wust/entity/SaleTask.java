package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
/*员工--每月销售目标与实际业绩*/
public class SaleTask {

    private String staff_id;//销售ID
    private String month;//月份
    private Integer month_task;//月销售金额目标
    private Integer week_one;//每月第一周目标
    private Integer week_two;//每月第二周目标
    private Integer week_three;//每月第三周目标
    private Integer week_four;//每月第四周目标
    private Integer week_five;//每月第五周目标
    private Integer week_six;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date load_time;//提交日期
    private String load_time_str;
    private Integer month_task_actual;//每月实际销售金额
    private Integer week_one_actual;//每月第一周实际销售金额
    private Integer week_two_actual;//每月第二周实际销售金额
    private Integer week_three_actual;//每月第三周实际销售金额
    private Integer week_four_actual;//每月第四周实际销售金额
    private Integer week_five_actual;//每月第五周实际销售金额
    private Integer week_six_actual;
    private Integer sign_up;//
    private Integer average;//实际平均每月销售金额

    // 需要的属性
    private String staff_name;//销售人员信息
    private Integer campus_id;//校区ID
    private String campus_name;//校区姓名




    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getMonth_task() {
        return month_task;
    }

    public void setMonth_task(Integer month_task) {
        this.month_task = month_task;
    }

    public Integer getWeek_one() {
        return week_one;
    }

    public void setWeek_one(Integer week_one) {
        this.week_one = week_one;
    }

    public Integer getWeek_two() {
        return week_two;
    }

    public void setWeek_two(Integer week_two) {
        this.week_two = week_two;
    }

    public Integer getWeek_three() {
        return week_three;
    }

    public void setWeek_three(Integer week_three) {
        this.week_three = week_three;
    }

    public Integer getWeek_four() {
        return week_four;
    }

    public void setWeek_four(Integer week_four) {
        this.week_four = week_four;
    }

    public Integer getWeek_five() {
        return week_five;
    }

    public void setWeek_five(Integer week_five) {
        this.week_five = week_five;
    }

    public Integer getWeek_six() {
        return week_six;
    }

    public void setWeek_six(Integer week_six) {
        this.week_six = week_six;
    }

    public Date getLoad_time() {
        return load_time;
    }

    public void setLoad_time(Date load_time) {
        this.load_time = load_time;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getLoad_time_str() {
        if(load_time != null){
            load_time_str = DateUtils.dateToString(load_time,"yyyy-MM-dd HH:mm:ss");
        }
        return load_time_str;
    }

    public void setLoad_time_str(String load_time_str) {
        this.load_time_str = load_time_str;
    }

    public Integer getMonth_task_actual() {
        return month_task_actual;
    }

    public void setMonth_task_actual(Integer month_task_actual) {
        this.month_task_actual = month_task_actual;
    }

    public Integer getWeek_one_actual() {
        return week_one_actual;
    }

    public void setWeek_one_actual(Integer week_one_actual) {
        this.week_one_actual = week_one_actual;
    }

    public Integer getWeek_two_actual() {
        return week_two_actual;
    }

    public void setWeek_two_actual(Integer week_two_actual) {
        this.week_two_actual = week_two_actual;
    }

    public Integer getWeek_three_actual() {
        return week_three_actual;
    }

    public void setWeek_three_actual(Integer week_three_actual) {
        this.week_three_actual = week_three_actual;
    }

    public Integer getWeek_four_actual() {
        return week_four_actual;
    }

    public void setWeek_four_actual(Integer week_four_actual) {
        this.week_four_actual = week_four_actual;
    }

    public Integer getWeek_five_actual() {
        return week_five_actual;
    }

    public void setWeek_five_actual(Integer week_five_actual) {
        this.week_five_actual = week_five_actual;
    }

    public Integer getWeek_six_actual() {
        return week_six_actual;
    }

    public void setWeek_six_actual(Integer week_six_actual) {
        this.week_six_actual = week_six_actual;
    }

    public Integer getSign_up() {
        return sign_up;
    }

    public void setSign_up(Integer sign_up) {
        this.sign_up = sign_up;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
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
