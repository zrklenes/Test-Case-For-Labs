package com.enes.testcaseapplicationforlabs.models;

public class Feed{

    private String name;
    private Boolean status;
    private int userId;
    private int imgId;

    public Feed(String name, Boolean status, int userId, int imgId) {
        this.name = name;
        this.status = status;
        this.userId = userId;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}