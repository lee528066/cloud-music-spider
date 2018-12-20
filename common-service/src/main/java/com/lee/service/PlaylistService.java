package com.lee.service;

import com.lee.dao.model.Playlist;

/**
 * @author liwei
 */
public interface PlaylistService {
    Playlist getByCloudPlaylistId(long cloudPlaylistId);
}
