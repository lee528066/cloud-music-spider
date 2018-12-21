package com.lee.service.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author liwei
 */
public class ResultUtils {

    public static <T> T findOne(List<T> list){
        return list.stream().findFirst().orElse(null);
    }
}
