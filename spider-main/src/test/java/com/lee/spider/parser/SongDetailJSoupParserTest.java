package com.lee.spider.parser;

import com.lee.spider.bo.SongBO;
import com.lee.test.TestCase;
import org.junit.Test;
import org.springframework.util.Assert;

import javax.annotation.Resource;


/**
 * @author liwei
 */
public class SongDetailJSoupParserTest extends TestCase {

    @Resource
    private SongDetailJSoupParser songDetailJSoupParser;

    @Test
    public void testParse(){
        SongBO songBO = songDetailJSoupParser.parse(457580323);
        Assert.notNull(songBO, "爬取歌曲详情失败");
    }

    @Test
    public void testAfterParse(){
        SongBO songBO = songDetailJSoupParser.parse(457580323);
        Assert.notNull(songBO, "爬取歌曲详情失败");

    }
}
