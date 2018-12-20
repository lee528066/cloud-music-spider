package com.lee.dao.model;

import java.util.Date;

public class Playlist {
    private Long id;

    private Long cloudPlaylistId;

    private String name;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCloudPlaylistId() {
        return cloudPlaylistId;
    }

    public void setCloudPlaylistId(Long cloudPlaylistId) {
        this.cloudPlaylistId = cloudPlaylistId;
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