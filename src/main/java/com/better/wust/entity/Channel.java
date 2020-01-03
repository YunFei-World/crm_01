package com.better.wust.entity;
/*
营销渠道
*/
public class Channel {

    private String channel_id;//渠道id
    private String onOffline;//线上或线下渠道
    private String channel_type;//渠道类型
    private Integer campus_id;//校区id
    private String campus_name;//校区名称

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getOnOffline() {
        return onOffline;
    }

    public void setOnOffline(String onOffline) {
        this.onOffline = onOffline;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
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
