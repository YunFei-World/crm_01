package com.better.wust.entity;
/*员工每周工作统计*/
public class StaffStatisticsMonth {

    private String staff_id;
    private Integer campus_id;

    private Integer sum_num;
    private Integer tel_num;
    private Integer effective;
    private Integer follow_up_effective;
    private Integer direct_shop;
    private Integer brought_shop;
    private Integer invitation_shop;
    private Integer actual_shop;
    private Integer sign_up;

    private Double tel_effective_proportion;
    private Double to_shop_proportion;
    private Double to_shop_to_sign_proportion;

    private String month;
    private Double month_task;
    private Double month_actual;
    private Double month_proportion;

    private Double week_one;
    private Double week_two;
    private Double week_three;
    private Double week_four;
    private Double week_five;
    private Double week_six;
    private Double week_one_actual;
    private Double week_two_actual;
    private Double week_three_actual;
    private Double week_four_actual;
    private Double week_five_actual;
    private Double week_six_actual;


    private String start_date;
    private String end_date;

    private Double average_sale;

    // 需要的属性
    private String staff_name;
    private String staff_post;
    private String campus_name;


    public Double getWeek_six() {
        return week_six;
    }

    public void setWeek_six(Double week_six) {
        this.week_six = week_six;
    }

    public Double getWeek_six_actual() {
        return week_six_actual;
    }

    public void setWeek_six_actual(Double week_six_actual) {
        this.week_six_actual = week_six_actual;
    }

    public Double getAverage_sale() {
        return average_sale;
    }

    public void setAverage_sale(Double average_sale) {
        this.average_sale = average_sale;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }

    public Integer getSum_num() {
        return sum_num;
    }

    public void setSum_num(Integer sum_num) {
        this.sum_num = sum_num;
    }

    public Integer getTel_num() {
        return tel_num;
    }

    public void setTel_num(Integer tel_num) {
        this.tel_num = tel_num;
    }

    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    public Integer getFollow_up_effective() {
        return follow_up_effective;
    }

    public void setFollow_up_effective(Integer follow_up_effective) {
        this.follow_up_effective = follow_up_effective;
    }

    public Integer getDirect_shop() {
        return direct_shop;
    }

    public void setDirect_shop(Integer direct_shop) {
        this.direct_shop = direct_shop;
    }

    public Integer getBrought_shop() {
        return brought_shop;
    }

    public void setBrought_shop(Integer brought_shop) {
        this.brought_shop = brought_shop;
    }

    public Integer getInvitation_shop() {
        return invitation_shop;
    }

    public void setInvitation_shop(Integer invitation_shop) {
        this.invitation_shop = invitation_shop;
    }

    public Integer getActual_shop() {
        return actual_shop;
    }

    public void setActual_shop(Integer actual_shop) {
        this.actual_shop = actual_shop;
    }

    public Integer getSign_up() {
        return sign_up;
    }

    public void setSign_up(Integer sign_up) {
        this.sign_up = sign_up;
    }

    public Double getTel_effective_proportion() {
        return tel_effective_proportion;
    }

    public void setTel_effective_proportion(Double tel_effective_proportion) {
        this.tel_effective_proportion = tel_effective_proportion;
    }

    public Double getTo_shop_proportion() {
        return to_shop_proportion;
    }

    public void setTo_shop_proportion(Double to_shop_proportion) {
        this.to_shop_proportion = to_shop_proportion;
    }

    public Double getTo_shop_to_sign_proportion() {
        return to_shop_to_sign_proportion;
    }

    public void setTo_shop_to_sign_proportion(Double to_shop_to_sign_proportion) {
        this.to_shop_to_sign_proportion = to_shop_to_sign_proportion;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getMonth_task() {
        return month_task;
    }

    public void setMonth_task(Double month_task) {
        this.month_task = month_task;
    }

    public Double getMonth_actual() {
        return month_actual;
    }

    public void setMonth_actual(Double month_actual) {
        this.month_actual = month_actual;
    }

    public Double getMonth_proportion() {
        return month_proportion;
    }

    public void setMonth_proportion(Double month_proportion) {
        this.month_proportion = month_proportion;
    }

    public Double getWeek_one() {
        return week_one;
    }

    public void setWeek_one(Double week_one) {
        this.week_one = week_one;
    }

    public Double getWeek_two() {
        return week_two;
    }

    public void setWeek_two(Double week_two) {
        this.week_two = week_two;
    }

    public Double getWeek_three() {
        return week_three;
    }

    public void setWeek_three(Double week_three) {
        this.week_three = week_three;
    }

    public Double getWeek_four() {
        return week_four;
    }

    public void setWeek_four(Double week_four) {
        this.week_four = week_four;
    }

    public Double getWeek_five() {
        return week_five;
    }

    public void setWeek_five(Double week_five) {
        this.week_five = week_five;
    }

    public Double getWeek_one_actual() {
        return week_one_actual;
    }

    public void setWeek_one_actual(Double week_one_actual) {
        this.week_one_actual = week_one_actual;
    }

    public Double getWeek_two_actual() {
        return week_two_actual;
    }

    public void setWeek_two_actual(Double week_two_actual) {
        this.week_two_actual = week_two_actual;
    }

    public Double getWeek_three_actual() {
        return week_three_actual;
    }

    public void setWeek_three_actual(Double week_three_actual) {
        this.week_three_actual = week_three_actual;
    }

    public Double getWeek_four_actual() {
        return week_four_actual;
    }

    public void setWeek_four_actual(Double week_four_actual) {
        this.week_four_actual = week_four_actual;
    }

    public Double getWeek_five_actual() {
        return week_five_actual;
    }

    public void setWeek_five_actual(Double week_five_actual) {
        this.week_five_actual = week_five_actual;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_post() {
        return staff_post;
    }

    public void setStaff_post(String staff_post) {
        this.staff_post = staff_post;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }
}
