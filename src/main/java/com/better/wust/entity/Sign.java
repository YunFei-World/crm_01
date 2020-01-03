package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*订单详情  订单---销售单更新后 有购课需求的客户进一步补充*/
public class Sign {
    private String sign_id;//订单ID
    private String sale_id;//销售单id3
    private String price_id;//

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sign_date;//订单生成日期？？？
    private String sign_date_str;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date estimate_time;//订单完成估计日期？？？
    private String estimate_time_str;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date actual_time;//订单时间完成日期？？？？
    private String actual_time_str;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date load_time;

    // 需要属性
    private String customer_name;//客户姓名
    private String customer_contact;//客户联系方式
    private String relation;//客户与学生关系
    private String stu_name;//学生姓名
    private String assign_staff_id;//销售人员ID
    private String assign_staff_name;//销售人员姓名
    private Integer id;


    private String campus_name;//校区名称
    private Integer campus_id;//校区ID


    private String student_sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date student_birthday;
    private String student_birthday_str;
    private String student_phone;

    private Integer course_id;//课程ID
    private String course_name;//课程名称
    private Double unit_price;//每节课程费用
    private Integer lessonNum;//课程数量
    private Double totalPrice;//课程总价
    private Double final_price;//最终价格
    private int order_course_num;//默认为0  当选项按课次计费课次  输入       如果选择每期课程  默认此项属性 为期课程的课次数
    private int chargetype;

    private Double reward_balance;//优惠卷

    private String remark;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "sign_id='" + sign_id + '\'' +
                ", sale_id='" + sale_id + '\'' +
                ", final_price=" + final_price +
                ", sign_date=" + sign_date +
                ", stu_name='" + stu_name + '\'' +
                ", assign_staff_id='" + assign_staff_id + '\'' +
                ", course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", student_birthday=" + student_birthday +
                ", reward_balance=" + reward_balance +
                '}';
    }


    public int getChargetype() {
        return chargetype;
    }

    public void setChargetype(int chargetype) {
        this.chargetype = chargetype;
    }

    public int getOrder_course_num() {
        return order_course_num;
    }

    public void setOrder_course_num(int order_course_num) {
        this.order_course_num = order_course_num;
    }

    public Date getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(Date student_birthday) {
        this.student_birthday = student_birthday;
    }

    public String getStudent_birthday_str() {

        if (student_birthday != null) {
            student_birthday_str = DateUtils.dateToString(student_birthday, "yyyy-MM-dd");
        }

        return student_birthday_str;
    }

    public void setStudent_birthday_str(String student_birthday_str) {
        this.student_birthday_str = student_birthday_str;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }


    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public Double getReward_balance() {
        return reward_balance;
    }

    public void setReward_balance(Double reward_balance) {
        this.reward_balance = reward_balance;
    }

    public String getSign_id() {
        return sign_id;
    }

    public void setSign_id(String sign_id) {
        this.sign_id = sign_id;
    }

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getPrice_id() {
        return price_id;
    }

    public void setPrice_id(String price_id) {
        this.price_id = price_id;
    }

    public Double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(Double final_price) {
        this.final_price = final_price;
    }

    public Date getSign_date() {
        return sign_date;
    }

    public void setSign_date(Date sign_date) {
        this.sign_date = sign_date;
    }

    public Date getEstimate_time() {
        return estimate_time;
    }

    public void setEstimate_time(Date estimate_time) {
        this.estimate_time = estimate_time;
    }

    public Date getActual_time() {
        return actual_time;
    }

    public void setActual_time(Date actual_time) {
        this.actual_time = actual_time;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getAssign_staff_id() {
        return assign_staff_id;
    }

    public void setAssign_staff_id(String assign_staff_id) {
        this.assign_staff_id = assign_staff_id;
    }

    public String getAssign_staff_name() {
        return assign_staff_name;
    }

    public void setAssign_staff_name(String assign_staff_name) {
        this.assign_staff_name = assign_staff_name;
    }

    public String getSign_date_str() {
        if(sign_date != null){
            sign_date_str = DateUtils.dateToString(sign_date,"yyyy-MM-dd");
        }
        return sign_date_str;
    }

    public void setSign_date_str(String sign_date_str) {
        this.sign_date_str = sign_date_str;
    }

    public String getEstimate_time_str() {
        if(estimate_time != null){
            estimate_time_str = DateUtils.dateToString(estimate_time,"yyyy-MM-dd HH:mm:ss");
        }
        return estimate_time_str;
    }

    public void setEstimate_time_str(String estimate_time_str) {
        this.estimate_time_str = estimate_time_str;
    }

    public String getActual_time_str() {
        if(actual_time != null){
            actual_time_str = DateUtils.dateToString(actual_time,"yyyy-MM-dd HH:mm:ss");
        }
        return actual_time_str;
    }

    public void setActual_time_str(String actual_time_str) {
        this.actual_time_str = actual_time_str;
    }

    public Date getLoad_time() {
        return load_time;
    }

    public void setLoad_time(Date load_time) {
        this.load_time = load_time;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public Integer getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Integer campus_id) {
        this.campus_id = campus_id;
    }
}
