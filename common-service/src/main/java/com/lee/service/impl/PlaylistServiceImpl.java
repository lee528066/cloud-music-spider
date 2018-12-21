package com.lee.service.impl;

import com.lee.dao.mapper.PlaylistMapper;
import com.lee.dao.model.Playlist;
import com.lee.dao.model.PlaylistExample;
import com.lee.service.PlaylistService;
import com.lee.service.utils.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        return ResultUtils.findOne(playlistMapper.selectByExample(example));
    }
}
