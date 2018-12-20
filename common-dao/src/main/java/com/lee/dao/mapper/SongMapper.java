package com.lee.dao.mapper;

import com.lee.dao.mapper.base.BaseMapper;
import com.lee.dao.model.Song;
import com.lee.dao.model.SongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SongMapper extends BaseMapper<Song, SongExample, Long> {
}