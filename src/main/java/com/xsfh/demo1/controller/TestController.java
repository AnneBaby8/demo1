package com.xsfh.demo1.controller;

import cn.licoy.encryptbody.annotation.encrypt.EncryptBody;
import cn.licoy.encryptbody.enums.EncryptBodyMethod;
import com.xsfh.demo1.entity.Item;
import com.xsfh.demo1.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  测试模块
 */
//RestController注解包含了 @Controller 和 @ResponseBody 注解。 @ResponseBody 注解是将返回的数据结构转换为 JSON 格式。
@RestController
@Slf4j
@RequestMapping("test")
public class TestController {
    /**
     * 返回一个字符串
     * @return
     */
    @GetMapping("test1")
    private String getStr1(){
        return "返回的是一个字符串哦";
    }

    /**
     * 返回一个对象类
     * @return
     */
    @GetMapping("test2")
    private Student getStr2(){
        Student student = new Student();
        student.setId(2L);
        student.setStuName("xiao ming");
        student.setStuAge(18);
        return student;
    }

    /**
     * 运行时异常
     * @return
     */
    @GetMapping("/wrong")
    public int error(){
        int i = 9/0;
        return i;
    }

    /**
     * 自定义异常
     */
    @GetMapping("error1")
    public void empty(){
        throw new RuntimeException("自定义异常");
    }

    /**
     * 反射(还有问题)
     */
    @GetMapping("reflect")
    public void reflect() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        //创建对象的两种方式
        Class<Item> itemClass = Item.class;
        //1.直接newInstance
        Constructor<Item> itemConstructor = itemClass.getDeclaredConstructor();
        Item item = itemConstructor.newInstance();
        log.info("newinstance的对象为：[{}]",item);

        //获取方法
        Method method = itemClass.getMethod("selectAllByOrderId", int.class);
        //执行方法
        Object invoke = method.invoke(item, 1);

    }

    /**
     * 单一接口加解密
     * @return
     */
    @GetMapping("encrypt")
    @ResponseBody
    @EncryptBody(value = EncryptBodyMethod.AES)
    public String test(){
        return "hello world";
    }
}
