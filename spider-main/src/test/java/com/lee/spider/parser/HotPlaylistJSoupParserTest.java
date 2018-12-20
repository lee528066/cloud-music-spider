package com.lee.spider.parser;

import com.lee.dao.mapper.PlaylistMapper;
import com.lee.dao.model.Playlist;
import com.lee.test.TestCase;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liwei
 */
public class HotPlaylistJSoupParserTest extends TestCase {
    @Resource
    private HotPlaylistJSoupParser hotPlaylistJSoupParser;
    @Resource
    private PlaylistMapper playlistMapper;

    @Test
    @Rollback(false)
    public void testParse(){
        List<Playlist> playlists = hotPlaylistJSoupParser.parse();
        Assert.notEmpty(playlists, "爬取歌单失败");
        playlists.forEach(it->playlistMapper.insert(it));
    }
}
