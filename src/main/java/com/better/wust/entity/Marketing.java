package com.better.wust.entity;

import com.better.wust.tools.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*活动*/
public class Marketing {

    private String marketing_id;//活动ID
    private String marketing_name;//活动名称
    private String marketing_place;//活动地点
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date marketing_date;//活动举行时间
    private String marketing_date_str;
    private String marketing_staff;//活动职员姓名
    private String marketing_content;//活动相关介绍
    private Double marketing_fee;//活动经费
    private String marketing_node;//？？？
    private Integer order_num;//预期发放毛单数量
    private Integer order_effective;//实际发放毛单数量
    private Integer order_wait;
    private Integer order_uneffective;//实际发放毛单数量
    private Integer order_uncontect;
    private Integer order_uncall;//实际发放毛单数量



    private Double proportion;//预期和实际比率
    private Double proportion_two;//预期和实际比率
    private Double proportion_three;//预期和实际比率
    private Double proportion_four;//预期和实际比率
    private Double proportion_five;//预期和实际比率

    private String url_first;//活动相关URL
    private String remark_first;//活动备注
    private String url_second;//活动i相关URL 2
    private String remark_second;//活动备注 2


    /* my添加*/
    private String channel_id;//渠道id
    private String channel_type;//渠道名称


    @Override
    public String toString() {
        return "Marketing{" +
                "marketing_id='" + marketing_id + '\'' +
                ", marketing_name='" + marketing_name + '\'' +
                ", channel_id='" + channel_id + '\'' +
                ", channel_type='" + channel_type + '\'' +
                '}';
    }


    public Integer getOrder_wait() {
        return order_wait;
    }

    public void setOrder_wait(Integer order_wait) {
        this.order_wait = order_wait;
    }

    public Integer getOrder_uncontect() {
        return order_uncontect;
    }

    public void setOrder_uncontect(Integer order_uncontect) {
        this.order_uncontect = order_uncontect;
    }

    public Double getProportion_four() {
        return proportion_four;
    }

    public void setProportion_four(Double proportion_four) {
        this.proportion_four = proportion_four;
    }

    public Double getProportion_five() {
        return proportion_five;
    }

    public void setProportion_five(Double proportion_five) {
        this.proportion_five = proportion_five;
    }

    public Integer getOrder_uneffective() {
        return order_uneffective;
    }

    public void setOrder_uneffective(Integer order_uneffective) {
        this.order_uneffective = order_uneffective;
    }

    public Integer getOrder_uncall() {
        return order_uncall;
    }

    public void setOrder_uncall(Integer order_uncall) {
        this.order_uncall = order_uncall;
    }

    public Double getProportion_two() {
        return proportion_two;
    }

    public void setProportion_two(Double proportion_two) {
        this.proportion_two = proportion_two;
    }

    public Double getProportion_three() {
        return proportion_three;
    }

    public void setProportion_three(Double proportion_three) {
        this.proportion_three = proportion_three;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getUrl_first() {
        return url_first;
    }

    public void setUrl_first(String url_first) {
        this.url_first = url_first;
    }

    public String getRemark_first() {
        return remark_first;
    }

    public void setRemark_first(String remark_first) {
        this.remark_first = remark_first;
    }

    public String getUrl_second() {
        return url_second;
    }

    public void setUrl_second(String url_second) {
        this.url_second = url_second;
    }

    public String getRemark_second() {
        return remark_second;
    }

    public void setRemark_second(String remark_second) {
        this.remark_second = remark_second;
    }

    public String getMarketing_id() {
        return marketing_id;
    }

    public void setMarketing_id(String marketing_id) {
        this.marketing_id = marketing_id;
    }

    public String getMarketing_name() {
        return marketing_name;
    }

    public void setMarketing_name(String marketing_name) {
        this.marketing_name = marketing_name;
    }

    public String getMarketing_place() {
        return marketing_place;
    }

    public void setMarketing_place(String marketing_place) {
        this.marketing_place = marketing_place;
    }

    public Date getMarketing_date() {
        return marketing_date;
    }

    public void setMarketing_date(Date marketing_date) {
        this.marketing_date = marketing_date;
    }

    public String getMarketing_date_str() {
        if (marketing_date != null){
            marketing_date_str = DateUtils.dateToString(marketing_date, "yyyy-MM-dd");
        }
        return marketing_date_str;
    }

    public void setMarketing_date_str(String marketing_date_str) {
        this.marketing_date_str = marketing_date_str;
    }

    public String getMarketing_staff() {
        return marketing_staff;
    }

    public void setMarketing_staff(String marketing_staff) {
        this.marketing_staff = marketing_staff;
    }

    public String getMarketing_content() {
        return marketing_content;
    }

    public void setMarketing_content(String marketing_content) {
        this.marketing_content = marketing_content;
    }

    public Double getMarketing_fee() {
        return marketing_fee;
    }

    public void setMarketing_fee(Double marketing_fee) {
        this.marketing_fee = marketing_fee;
    }

    public String getMarketing_node() {
        return marketing_node;
    }

    public void setMarketing_node(String marketing_node) {
        this.marketing_node = marketing_node;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public Integer getOrder_effective() {
        return order_effective;
    }

    public void setOrder_effective(Integer order_effective) {
        this.order_effective = order_effective;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

}
