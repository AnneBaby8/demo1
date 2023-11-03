package com.xsfh.demo1.test.encrypt.encrypt01.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 加密方法注解（方法 作切入点）
 */
@Target(ElementType.METHOD)//标志该注解只能用在方法上
@Retention(RetentionPolicy.RUNTIME)//元注解，标志该注解在运行时生效
public @interface Encryption {

}
