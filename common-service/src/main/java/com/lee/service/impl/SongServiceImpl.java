package com.lee.service.impl;

import com.lee.dao.mapper.SongMapper;
import com.lee.dao.model.Song;
import com.lee.dao.model.SongExample;
import com.lee.service.SongService;
import com.lee.service.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liwei
 */
@Service
public class SongServiceImpl implements SongService {
    @Resource
    private SongMapper songMapper;

    @Override
    public Song getByCouldSongId(long cloudSongId) {
        SongExample example = new SongExample();
        example.createCriteria().andCloudSongIdEqualTo(cloudSongId);
        return ResultUtils.findOne(songMapper.selectByExample(example));
    }
}
