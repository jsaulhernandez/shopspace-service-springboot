package com.shopspace.shopspaceservice.util;

import org.springframework.stereotype.Component;

@Component
public class LongUtil {
    public static Long cleanLongZero(Long value) {
        return value != null && value > 0 ? value : null;
    }
}
