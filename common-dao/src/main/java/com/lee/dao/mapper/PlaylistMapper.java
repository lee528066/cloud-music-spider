package com.lee.dao.mapper;

import com.lee.dao.mapper.base.BaseMapper;
import com.lee.dao.model.Playlist;
import com.lee.dao.model.PlaylistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlaylistMapper extends BaseMapper<Playlist, PlaylistExample, Long> {
}