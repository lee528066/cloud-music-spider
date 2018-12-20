package com.lee.spider.parser;

import com.lee.dao.mapper.SongMapper;
import com.lee.dao.model.Song;
import com.lee.test.TestCase;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liwei
 */
public class SongsByPlaylistJSoupParserTest extends TestCase {

    @Resource
    private SongsByPlaylistJSoupParser songsByPlaylistJSoupParser;
    @Resource
    private SongMapper songMapper;

    @Test
    @Rollback(false)
    public void testParse() {
        List<Song> songs = songsByPlaylistJSoupParser.parse(2561336046L);
        Assert.notEmpty(songs, "没有爬取到歌曲!");
        songs.forEach(song -> songMapper.insert(song));
    }
}
