package com.lee.spider.parser;

import com.google.common.collect.Lists;
import com.lee.dao.model.Playlist;
import com.lee.spider.constant.ParserConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 热门歌单解析
 * @author liwei
 */
@Component
@Slf4j
public class HotPlaylistJSoupParser {

    public static final String PLAYLIST_URL = "https://music.163.com/discover/playlist";

    public List<Playlist> parse() {
        List<Playlist> playlists = Lists.newArrayList();
        try {
            Document document = Jsoup.connect(PLAYLIST_URL).get();
            Elements playLists = document.select(".msk");
            for (Element playList : playLists){
                String href = playList.attr("href");
                String name = playList.attr("title");
                String idStr = href.replaceAll(ParserConstants.PLAYLIST_ID, "");
                long id = StringUtils.isBlank(idStr) ? 0 : Long.valueOf(idStr);
                Playlist playlist = buildPlaylist(name, id);
                playlists.add(playlist);
            }
        } catch (IOException e) {
            log.error("获取热门歌单发生异常", e);
        }
        return playlists;
    }

    private Playlist buildPlaylist(String name, long id) {
        Playlist playlist = new Playlist();
        playlist.setCloudPlaylistId(id);
        playlist.setName(name);
        playlist.setCreateTime(new Date());
        playlist.setUpdateTime(new Date());
        return playlist;
    }
}
