package com.lee.spider.parser;

import com.google.common.collect.Lists;
import com.lee.dao.model.Playlist;
import com.lee.dao.model.Song;
import com.lee.service.PlaylistService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 根据歌单id获取歌曲集合
 * @author liwei
 */
@Component
@Slf4j
public class SongsByPlaylistJSoupParser {

    public static final String SONGS_URL = "https://music.163.com/playlist?id=";

    @Resource
    private PlaylistService playlistService;

    public List<Song> parse(long couldPlaylistId){
        List<Song> songList = Lists.newArrayList();
        Playlist playlist = playlistService.getByCloudPlaylistId(couldPlaylistId);
        try {
            Document document = Jsoup.connect(SONGS_URL + couldPlaylistId).get();
            Elements songs = document.select("[href^=/song?id=]");
            for (Element eSong : songs){
                String name = eSong.html();
                String href = eSong.attr("href");
                String idStr = href.replaceAll("/song\\?id=", "");
                long id = StringUtils.isBlank(idStr) ? 0 : Long.valueOf(idStr);
                Song song = buildSong(couldPlaylistId, playlist, name, id);
                songList.add(song);
            }
        } catch (IOException e) {
            log.error("获取歌单中的歌曲列表发生异常", e);
        }
        return songList;
    }

    private Song buildSong(long couldPlaylistId, Playlist playlist, String name, long id) {
        Song song = new Song();
        song.setPlaylistId(playlist.getId());
        song.setCloudPlaylistId(couldPlaylistId);
        song.setCloudSongId(id);
        song.setName(name);
        song.setCreateTime(new Date());
        song.setUpdateTime(new Date());
        return song;
    }
}
