package com.lee.spider.bo;

import com.lee.dao.model.Playlist;
import com.lee.dao.model.Song;
import com.lee.dao.model.SongArtist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author liwei
 */
@Getter
@Setter
public class SongBO {
    private Song song;
    private List<SongArtist> songArtists;
    private List<Song> recommendSongs;
    private List<Playlist> recommendPlaylists;
}
