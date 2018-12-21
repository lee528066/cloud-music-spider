package com.lee.dao.mapper;

import com.lee.dao.mapper.base.BaseMapper;
import com.lee.dao.model.SongArtist;
import com.lee.dao.model.SongArtistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SongArtistMapper extends BaseMapper<SongArtist, SongArtistExample, Long> {
}