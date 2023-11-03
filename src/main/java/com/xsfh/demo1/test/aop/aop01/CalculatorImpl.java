package com.xsfh.demo1.test.aop.aop01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 计算器实现类
 */
@Service
@Slf4j
@Component
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int num1, int num2) {return num1+num2;}

    @Override
    public int subtraction(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1*num2;
    }

    @Override
    public int division(int num1, int num2) {
        return num1/num2;
    }
}
