package com.lee.spider.parser.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @author liwei
 */
@Slf4j
public class MusicEncryptUtils {

    /***
     * 密钥
     */
    public static String sKey = "0CoJUm6Qyw8W8jud";
    /**
     * 偏移量
     */
    private static String ivParameter = "0102030405060708";
    private static String context = "{rid: \"R_SO_4_25641368\",offset: \"0\",total: \"true\",limit: \"20\",csrf_token: \"\"}";

    /**
     * aes加密
     * @param content 加密内容
     * @param sKey 偏移量
     * @return
     */
    public static String AESEncrypt(String content,String sKey) {
        try {
            byte[] encryptedBytes;
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes(), "AES");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            encryptedBytes = cipher.doFinal(byteContent);
            return new String(Base64Utils.encode(encryptedBytes), StandardCharsets.UTF_8);
        } catch (Exception e){
            log.error("加密参数失败", e);
        }
        return null;
    }

    public static String rsaEncrypt() {
        return "2cfbb5da33394cfd8b99d260946821cee60f63d1438615cef40a9c9ea4dec0a455e1ca763cbc24fe1d2874ece856b2aa35f1b797b7fbc385625ca71b112b1893ec878fd1f0c226e2f720bfcb0e4240036bbf569abd95372b48d69b20d7122af78bacc5c4ae5c9fb038144ba3298fa76f8b502ca216a4d8f320f79f4486e736c8";
    }
}
