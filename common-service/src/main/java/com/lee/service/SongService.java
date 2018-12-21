package com.lee.service;

import com.lee.dao.model.Song;

/**
 * @author liwei
 */
public interface SongService {
    Song getByCouldSongId(long cloudSongId);
}
