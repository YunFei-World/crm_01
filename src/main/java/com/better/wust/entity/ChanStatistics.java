package com.better.wust.entity;
/*每个校区-渠道月统计  --各种渠道   ID1   ID2   ....  IDn*/
public class ChanStatistics {

    private String statistics_month;//月份
    private String channel_id;//渠道ID

    private String campus_name;//校区名字
    private Integer campus_id;//校区ID

    private String time_start;//月份
    private String time_end;//月份

    private String onOffline;
    private  String channel_type;//渠道的类型

    private Integer count_sumnum;//统计数量
    private Integer count_effective;
    private Integer count_wait;
    private Integer count_uneffective;
    private Integer count_uncontect;
    private Integer count_uncall;//统计数量

    private double one_proportion;
    private double two_proportion;
    private double three_proportion;
    private double four_proportion;
    private double five_proportion;


    public Integer getCount_wait() {
        return count_wait;
    }

    public void setCount_wait(Integer count_wait) {
        this.count_wait = count_wait;
    }

    public Integer getCount_uncontect() {
        return count_uncontect;
    }

    public void setCount_uncontect(Integer count_uncontect) {
        this.count_uncontect = count_uncontect;
    }

    public double getOne_proportion() {
        return one_proportion;
    }

    public void setOne_proportion(double one_proportion) {
        this.one_proportion = one_proportion;
    }

    public double getTwo_proportion() {
        return two_proportion;
    }

    public void setTwo_proportion(double two_proportion) {
        this.two_proportion = two_proportion;
    }

    public double getThree_proportion() {
        return three_proportion;
    }

    public void setThree_proportion(double three_proportion) {
        this.three_proportion = three_proportion;
    }

    public double getFour_proportion() {
        return four_proportion;
    }

    public void setFour_proportion(double four_proportion) {
        this.four_proportion = four_proportion;
    }

    public double getFive_proportion() {
        return five_proportion;
    }

    public void setFive_proportion(double five_proportion) {
        this.five_proportion = five_proportion;
    }

    public Integer getCount_sumnum() {
        return count_sumnum;
    }

    public void setCount_sumnum(Integer count_sumnum) {
        this.count_sumnum = count_sumnum;
    }

    public Integer getCount_effective() {
        return count_effective;
    }

    public void setCount_effective(Integer count_effective) {
        this.count_effective = count_effective;
    }

    public Integer getCount_uneffective() {
        return count_uneffective;
    }

    public void setCount_uneffective(Integer count_uneffective) {
        this.count_uneffective = count_uneffective;
    }

    public Integer getCount_uncall() {
        return count_uncall;
    }

    public void setCount_uncall(Integer count_uncall) {
        this.count_uncall = count_uncall;
    }

    public String getOnOffline() {
        return onOffline;
    }

    public void setOnOffline(String onOffline) {
        this.onOffline = onOffline;
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

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }


    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
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
