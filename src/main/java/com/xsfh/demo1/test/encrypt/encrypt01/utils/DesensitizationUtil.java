package com.xsfh.demo1.test.encrypt.encrypt01.utils;

import cn.hutool.core.util.StrUtil;
import com.xsfh.demo1.test.encrypt.encrypt01.enums.DesensitizationEnum;

/**
 * 脱敏工具类
 */
public class DesensitizationUtil {
    public static Object desensitization(Object obj, DesensitizationEnum desensitizationEnum) {
        Object result;
        switch (desensitizationEnum) {
            case name:
                result = strUtilHide(obj, 1);
                break;
            case address:
                result = strUtilHide(obj, 3);
                break;
            default:
                result = "";
        }
        return result;
    }

    /**
     * start从0开始
     */
    public static Object strUtilHide(String obj, int start, int end) {
        return StrUtil.hide(obj, start, end);
    }

    public static Object strUtilHide(Object obj, int start) {
        return strUtilHide(((String) obj), start, ((String) obj).length());
    }

}

