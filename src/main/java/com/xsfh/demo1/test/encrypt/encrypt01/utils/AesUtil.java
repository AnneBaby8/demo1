package com.xsfh.demo1.test.encrypt.encrypt01.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.xsfh.demo1.test.encrypt.encrypt01.enums.DesensitizationEnum;

/**
 * 加密工具类
 */
public class AesUtil {

    // 默认16位 或 128 256位
    public static String AES_KEY = "Wk#qerdfdshbd910";

    public static AES aes = SecureUtil.aes(AES_KEY.getBytes());

    public static Object encrypt(Object obj) {
        return aes.encryptHex((String) obj);
    }

    public static Object decrypt(Object obj, DesensitizationEnum desensitizationEnum) {
        // 解密
        Object decrypt = decrypt(obj);
        // 脱敏
        return DesensitizationUtil.desensitization(decrypt, desensitizationEnum);
    }

    public static Object decrypt(Object obj) {
        return aes.decryptStr((String) obj, CharsetUtil.CHARSET_UTF_8);
    }

}

