package com.xsfh.demo1.test.encrypt.encrypt01.aspect;

import com.xsfh.demo1.test.encrypt.encrypt01.annotation.EncryptField;
import com.xsfh.demo1.test.encrypt.encrypt01.bo.StudentBO;
import com.xsfh.demo1.test.encrypt.encrypt01.bo.UserBO;
import com.xsfh.demo1.test.encrypt.encrypt01.utils.AesUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 加密切面
 */
@Slf4j
@Aspect
@Component
public class EncryptAspect {

    //拦截需加密注解（定义切点）
    @Pointcut("@annotation(com.xsfh.demo1.test.encrypt.encrypt01.annotation.Encryption)")
    public void point() {

    }
    //定义通知（参数为切点的方法名）
    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //加密
        encrypt(joinPoint);
        return joinPoint.proceed();
    }

    public void encrypt(ProceedingJoinPoint joinPoint) {
        Object[] objects;
        try {
            objects = joinPoint.getArgs();
            if (objects.length != 0) {
                for (Object object : objects) {
                   // if (object instanceof StudentBO) {
                        Field[] fields = object.getClass().getDeclaredFields();
                        for (Field field : fields) {
                            if (field.isAnnotationPresent(EncryptField.class)) {
                                field.setAccessible(true);
                                if (field.get(object) != null) {
                                    // 进行加密
                                    Object o = field.get(object);
                                    Object encrypt = AesUtil.encrypt(field.get(object));
                                    field.set(object, encrypt);
                                }
                            }
                     //   }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}