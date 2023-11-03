package com.xsfh.demo1.test.encrypt.encrypt01.aspect;

import com.xsfh.demo1.test.encrypt.encrypt01.annotation.DecryptField;
import com.xsfh.demo1.test.encrypt.encrypt01.enums.DesensitizationEnum;
import com.xsfh.demo1.test.encrypt.encrypt01.utils.AesUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 解密脱敏切面
 */
@Slf4j
@Aspect
@Component
public class DecryptAspect {
    //拦截需解密注解
    @Pointcut("@annotation(com.xsfh.demo1.test.encrypt.encrypt01.annotation.Decryption)")
    public void point() {

    }

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //解密
        return decrypt(joinPoint);
    }

    public Object decrypt(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            Object obj = joinPoint.proceed();
            if (obj != null) {
                //抛砖引玉 ，可自行扩展其他类型字段的判断
                if (obj instanceof String) {
                    decryptValue();
                } else {
                    result = decryptData(obj);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

    private Object decryptData(Object obj) throws IllegalAccessException {

        if (Objects.isNull(obj)) {
            return null;
        }
        if (obj instanceof ArrayList) {
            decryptList(obj);
        } else {
            decryptObj(obj);
        }
        return obj;
    }

    private void decryptObj(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(DecryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                if (field.get(obj) != null) {
                    String realValue = (String) field.get(obj);
                    DesensitizationEnum desensitizationEnum = field.getAnnotation(DecryptField.class).value();
                    String value = (String) AesUtil.decrypt(realValue,desensitizationEnum);
                    field.set(obj, value);
                }
            }
        }
    }

    private void decryptList(Object obj) throws IllegalAccessException {
        List<Object> result = new ArrayList<>();
        if (obj instanceof ArrayList) {
            result.addAll((Collection<?>) obj);
        }
        for (Object object : result) {
            decryptObj(object);
        }
    }

    private void decryptValue() {
        log.info("根据对象进行解密脱敏，单个字段不做处理！");
    }



}

