package com.xsfh.demo1.test.encrypt.encrypt01.annotation;

import com.xsfh.demo1.test.encrypt.encrypt01.enums.DesensitizationEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 解密字段注解（字段）
 */
@Target(ElementType.FIELD)//标志上一个字段注解
@Retention(RetentionPolicy.RUNTIME)//运行时有效
public @interface DecryptField {
    DesensitizationEnum value();

}
