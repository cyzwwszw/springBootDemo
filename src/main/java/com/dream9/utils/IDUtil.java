package com.dream9.utils;

import java.util.UUID;

/**
 * Created by dream9 on 2017/2/19.
 */
public class IDUtil {
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }
}
