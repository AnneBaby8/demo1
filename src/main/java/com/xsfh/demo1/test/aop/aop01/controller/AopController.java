package com.xsfh.demo1.test.aop.aop01.controller;

import com.xsfh.demo1.test.aop.aop01.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AOP模块
 */
@RestController
@RequestMapping("aop")
public class AopController {

    @Autowired
    private Calculator calculator;
    /**
     * 简单测试aop示例1
     */
    @GetMapping("testAOP01")
    public void testAOP01(){
        calculator.add(1,2);
        calculator.subtraction(1,2);
        calculator.multiply(1,2);
        calculator.division(1,2);
    }
    /**
     * 简单测试aop示例2
     */
    @GetMapping("testAOP02")
    public void testAOP02(){
        calculator.add(1,2);
        calculator.subtraction(1,2);
    }
}
