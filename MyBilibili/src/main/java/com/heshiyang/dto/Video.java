package com.heshiyang.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * LocalDateTime  年月日时分秒
 * LocalTime   时分秒
 * LocalDate   年月日
 */

public class Video {
    private String bv;  // 视频编码（BV号）
    private String title;  // 标题
    private LocalDateTime publishTime;  // 发布时间
    private String cover;  // 封面
    private String introduction;  // 简介
    private List<String> tagList;  // 多个标签

    private String tags;
// 因为数据库的tags是string格式的，而tagList是List<String>格式的，所以中间需要一个变量来进行转化
    public void setTags(String tags) {
        this.tags = tags;
    }

    private List<Play> playList;  //  多个Play

//    当前页面没有用到
    private String type;  //  类型：自制、转载
    private String category;  //  分区：生活、游戏、动漫

    public Video(String bv, String title, LocalDateTime publishTime, String cover, String introduction, List<String> tagList, List<Play> playList, String type, String category) {
        this.bv = bv;
        this.title = title;
        this.publishTime = publishTime;
        this.cover = cover;
        this.introduction = introduction;
        this.tagList = tagList;
        this.playList = playList;
        this.type = type;
        this.category = category;
    }

    public Video() {
    }

    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTagList() {
        String tags = this.tags;  //  获取到的是数据库的tags字符串
        if (tags == null || tags.equals("")) {
            return List.of();
        }
        String[] s = tags.split("_");
        return List.of(s);
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBv() {
        return bv;
    }

    public void setBv(String bv) {
        this.bv = bv;
    }
}
