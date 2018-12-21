package com.lee.dao.model;

import java.util.Date;

public class Song {
    private Long id;

    private Long cloudSongId;

    private String name;

    private Long cloudAlbumId;

    private String album;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCloudAlbumId() {
        return cloudAlbumId;
    }

    public void setCloudAlbumId(Long cloudAlbumId) {
        this.cloudAlbumId = cloudAlbumId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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