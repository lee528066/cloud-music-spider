package com.lee.dao.model;

import java.util.Date;

public class Song {
    private Long id;

    private Long playlistId;

    private Long cloudPlaylistId;

    private Long cloudSongId;

    private String name;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getCloudPlaylistId() {
        return cloudPlaylistId;
    }

    public void setCloudPlaylistId(Long cloudPlaylistId) {
        this.cloudPlaylistId = cloudPlaylistId;
    }

    public Long getCloudSongId() {
        return cloudSongId;
    }

    public void setCloudSongId(Long cloudSongId) {
        this.cloudSongId = cloudSongId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}