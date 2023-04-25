package com.example.yzu_community;

import android.graphics.Color;

public class HuodongListInfo {
    private int imgId;
    private String  status;
    private String title;
    private int statusColor;
    enum StatusCode{Preparing, Registering, EndRegistration, Doing, Ended}   //筹备中, 报名中, 报名截止, 进行中, 已结束

    public int getImgId() {
        return imgId;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
    public int getstatusColor() {
        return statusColor;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setStatus(StatusCode status) {
        switch (status) {
            case Preparing:
                this.status = "准备中";
                this.statusColor = Color.argb(180,174, 255, 167);
                break;
            case Registering:
                this.status = "报名中";
                this.statusColor = Color.argb(180,227, 255, 125);
                break;
            case EndRegistration:
                this.status = "报名截止";
                this.statusColor = Color.argb(180,255, 182, 148);
                break;
            case Doing:
                this.status = "进行中";
                this.statusColor = Color.argb(180,125, 222, 255);
                break;
            case Ended:
                this.status = "已结束";
                this.statusColor = Color.argb(180,255, 148, 148);
                break;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public HuodongListInfo(int imgId, StatusCode status, String title) {
        this.imgId = imgId;
        setStatus(status);
        this.title = title;
    }
}