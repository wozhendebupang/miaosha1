package com.zjy.util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 定义了简单的正则表达式和方法，用于验证手机号是否存在
 */
public class ValidatorUtil {

    //正则表达式，验证手机号是1开头的，位数 11位的
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    /**
     * 验证手机号是否存在，如果为 空，返回false，如果不为空，则看是否满足正则表达式
     * @param str
     * @return
     */
    public static boolean isMobile(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        Matcher m = mobile_pattern.matcher(str);
        return m.matches();
    }


}
