package com.shopspace.shopspaceservice.util;

import io.micrometer.common.util.StringUtils;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class StringUtil {
    public static String cleanStringEmpty(String search) {
        return (StringUtils.isNotEmpty(search) ? search : null);
    }
}
