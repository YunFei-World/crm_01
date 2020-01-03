package com.better.wust.entity;

public class StaffStatisticsTime {

    private String staff_id;//员工ID
    private Integer sum_num;//总共订单
    private Integer tel_num;//打电话数量
    private Integer effective;//有效订单
    private Integer follow_up_effective;
    private Integer direct_shop;
    private Integer brought_shop;
    private Integer invitation_shop;
    private Integer actual_shop;
    private Integer sign_up;

    private Double tel_effective_proportion;//打电话占总数比例
    private Double to_shop_proportion;
    private Double to_shop_to_sign_proportion;

    private String time_start;
    private String time_end;

    // 需要的数据
    private String staff_name;//员工姓名
    private String staff_post;
    private Integer campus_id;
    private String campus_name;

    public String getStaff_post() {
        return staff_post;
    }

    public void setStaff_post(String staff_post) {
        this.staff_post = staff_post;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
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

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
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
