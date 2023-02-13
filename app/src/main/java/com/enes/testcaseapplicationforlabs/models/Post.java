package com.enes.testcaseapplicationforlabs.models;

public class Post {

    private String username;
    private String hours;
    private int likecount;
    private int commentcount;
    private int savecount;
    private int userId;
    private int postId;
    private int userimage;
    private int postimage;

    public Post(String username, String hours, int likecount, int commentcount, int savecount, int userId, int postId, int userimage, int postimage) {
        this.username = username;
        this.hours = hours;
        this.likecount = likecount;
        this.commentcount = commentcount;
        this.savecount = savecount;
        this.userId = userId;
        this.postId = postId;
        this.userimage = userimage;
        this.postimage = postimage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getSavecount() {
        return savecount;
    }

    public void setSavecount(int savecount) {
        this.savecount = savecount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserimage() {
        return userimage;
    }

    public void setUserimage(int userimage) {
        this.userimage = userimage;
    }

    public int getPostimage() {
        return postimage;
    }

    public void setPostimage(int postimage) {
        this.postimage = postimage;
    }
}
