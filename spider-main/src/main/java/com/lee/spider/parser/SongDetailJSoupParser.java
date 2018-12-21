package com.lee.spider.parser;

import com.lee.dao.model.Playlist;
import com.lee.dao.model.Song;
import com.lee.dao.model.SongArtist;
import com.lee.service.SongService;
import com.lee.spider.bo.SongBO;
import com.lee.spider.constant.ParserConstants;
import com.lee.spider.parser.utils.ParserUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 相似歌曲 & 包含该歌曲的歌单
 *
 * @author liwei
 */
@Component
@Slf4j
public class SongDetailJSoupParser {

    public static final String SONG_RECOMMEND_URL = "https://music.163.com/song?id=";

    @Resource
    private SongService songService;

    public SongBO parse(long cloudSongId) {
        Song song = songService.getByCouldSongId(cloudSongId);
        Assert.notNull(song, "歌曲在数据库不存在");
        SongBO songBO = new SongBO();
        songBO.setSong(song);
        Document document = null;
        try {
            document = Jsoup.connect(SONG_RECOMMEND_URL + cloudSongId).get();
        } catch (IOException e) {
            log.error("爬取歌曲详情发生异常", e);
            return null;
        }

        //解析歌手:歌手可能是有多个情况
        Element eArtistsInfo = document.select("p:contains(" + ParserConstants.ARTIST + ")").first();
        Elements eArtists = eArtistsInfo.select("a");
        List<SongArtist> songArtists = eArtists.stream()
                .map(eArtist -> buildSongArtist(eArtist, song))
                .collect(Collectors.toList());
        songBO.setSongArtists(songArtists);

        //解析专辑
        Element eAlbumInfo = document.select("p:contains(" + ParserConstants.ALBUM + ")").first();
        Element eAlbum = eAlbumInfo.select("a").first();
        long cloudAlbumId = ParserUtils.idVal(eAlbum, ParserConstants.ALBUM_ID);
        String album = eAlbum.html();
        song.setCloudAlbumId(cloudAlbumId);
        song.setAlbum(album);

        //解析推荐歌曲
        Elements eRecommendSongs = document.select("[data-res-data*=song-song-recommend]");
        List<Song> recommendSongs = eRecommendSongs.stream()
                .map(this::buildRecommendSong)
                .collect(Collectors.toList());

        //解析推荐歌单
        Elements eRecommendPlaylists = document
                .select("[data-res-data*=song-playlist-recommend]")
                .select("a:has(img)");
        List<Playlist> recommendPlaylists = eRecommendPlaylists.stream()
                .map(this::buildRecommendPlaylist)
                .collect(Collectors.toList());

        songBO.setRecommendSongs(recommendSongs);
        songBO.setRecommendPlaylists(recommendPlaylists);
        return songBO;
    }

    private Song buildRecommendSong(Element eRecommendSong) {
        String idStr = eRecommendSong.attr("data-res-id");
        String name = eRecommendSong.attr("title");
        Song recommendSong = new Song();
        recommendSong.setCloudSongId(Long.valueOf(idStr));
        recommendSong.setName(name);
        recommendSong.setCreateTime(new Date());
        recommendSong.setUpdateTime(new Date());
        return recommendSong;
    }

    private Playlist buildRecommendPlaylist(Element eRecommendPlaylist) {
        String idStr = eRecommendPlaylist.attr("data-res-id");
        String name = eRecommendPlaylist.attr("title");
        Playlist playlist = new Playlist();
        playlist.setCloudPlaylistId(Long.valueOf(idStr));
        playlist.setName(name);
        playlist.setCreateTime(new Date());
        playlist.setUpdateTime(new Date());
        return playlist;
    }

    private SongArtist buildSongArtist(Element eArtist, Song song) {
        String artist = eArtist.html();
        long cloudArtistId = ParserUtils.idVal(eArtist, ParserConstants.ARTIST_ID);
        SongArtist songArtist = new SongArtist();
        songArtist.setSongId(song.getId());
        songArtist.setCloudSongId(song.getCloudSongId());
        songArtist.setArtist(artist);
        songArtist.setCloudArtistId(cloudArtistId);
        songArtist.setCreateTime(new Date());
        songArtist.setUpdateTime(new Date());
        return songArtist;
    }
}
