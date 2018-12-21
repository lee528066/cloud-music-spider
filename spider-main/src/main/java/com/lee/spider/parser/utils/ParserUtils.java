package com.lee.spider.parser.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/**
 * @author liwei
 */
public class ParserUtils {

    public static long idVal(Element element, String idKey) {
        String idStr = element.attr("href").replaceAll(idKey, "");
        return StringUtils.isBlank(idStr) ? 0 : Long.valueOf(idStr);
    }

    public static long idVal(String attr, String idKey) {
        String idStr = attr.replaceAll(idKey, "");
        return StringUtils.isBlank(idStr) ? 0 : Long.valueOf(idStr);
    }
}
