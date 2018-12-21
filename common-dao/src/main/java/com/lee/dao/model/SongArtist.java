package com.lee.dao.model;

import java.util.Date;

public class SongArtist {
    private Long id;

    private Long songId;

    private Long cloudSongId;

    private String artist;

    private Long cloudArtistId;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getCloudSongId() {
        return cloudSongId;
    }

    public void setCloudSongId(Long cloudSongId) {
        this.cloudSongId = cloudSongId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Long getCloudArtistId() {
        return cloudArtistId;
    }

    public void setCloudArtistId(Long cloudArtistId) {
        this.cloudArtistId = cloudArtistId;
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