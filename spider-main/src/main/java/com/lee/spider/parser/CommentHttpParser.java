package com.lee.spider.parser;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lee.dao.model.SongComment;
import com.lee.spider.parser.utils.MusicEncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author liwei
 */
@Component
@Slf4j
public class CommentHttpParser {

    public static final String COMMENT_URL = "https://music.163.com/weapi/v1/resource/comments/R_SO_4_%s?csrf_token=";

    public List<SongComment> parse(long cloudSongId){
        List<SongComment> songComments = Lists.newArrayList();
        HashMap<String, String> formData = Maps.newHashMap();
        formData.put("params", getParams(cloudSongId));
        formData.put("encSecKey", MusicEncryptUtils.rsaEncrypt());
        //TODO 需要引入新的post工具
        String body = HttpRequest.post(String.format(COMMENT_URL, cloudSongId)).form(formData).body();
        System.out.println(body);
        return songComments;
    }

    private String getParams(long cloudSongId) {
        String content = makeContent(String.valueOf(cloudSongId), "true", 1);
        String params = MusicEncryptUtils.AESEncrypt((MusicEncryptUtils.AESEncrypt(content, MusicEncryptUtils.sKey)),
                "FFFFFFFFFFFFFFFF");
        return params;
    }

    /**
     * @param songId     歌曲ID
     * @param paging     是否第一页 true 第一页  其余传入false
     * @param nowPageNum 当前页数
     * @return
     */
    public static String makeContent(String songId, String paging, int nowPageNum) {
        int offset;
        if (nowPageNum < 1) {
            offset = 20;
        }
        offset = (nowPageNum - 1) * 20;
        String baseContent = "{rid: \"R_SO_4_%s\",offset: \"%d\",total: \"%s\",limit: \"20\",csrf_token: \"\"}";
        return String.format(baseContent, songId, offset, paging);
    }

    public static void main(String[] args) {
        CommentHttpParser parser = new CommentHttpParser();
        parser.parse(457580323);
    }
}
