package com.lee.service.impl;

import com.lee.dao.mapper.PlaylistMapper;
import com.lee.dao.model.Playlist;
import com.lee.dao.model.PlaylistExample;
import com.lee.service.PlaylistService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liwei
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Resource
    private PlaylistMapper playlistMapper;

    @Override
    public Playlist getByCloudPlaylistId(long cloudPlaylistId) {
        PlaylistExample example = new PlaylistExample();
        example.createCriteria().andCloudPlaylistIdEqualTo(cloudPlaylistId);
        List<Playlist> playlists = playlistMapper.selectByExample(example);
        Assert.notEmpty(playlists, "当前歌单不存在");
        return playlists.get(0);
    }
}
