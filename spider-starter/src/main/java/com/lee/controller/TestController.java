package com.lee.controller;

import com.alibaba.fastjson.JSON;
import com.lee.dao.model.Playlist;
import com.lee.service.PlaylistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liwei
 */
@RestController
@RequestMapping("/index")
@Slf4j
public class TestController {

    @Resource
    private PlaylistService playlistService;

    @RequestMapping("/playlist")
    public String listPlaylist(){
        log.info("输出日志");
        Playlist playlist = playlistService.getByCloudPlaylistId(2561336046L);
        return JSON.toJSONString(playlist);
    }
}
