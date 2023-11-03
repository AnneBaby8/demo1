package com.xsfh.demo1.test.outerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * 局部内部类（声明在方法中的类）
 */
@Slf4j
public class OuterClass03 {
    private String name = "Annie";
    private int age = 18;

    public void getMethod(String sex){
        class InnerClass{
            public void print(){
                System.out.println(name);
                System.out.println(age);
                System.out.println(sex);
            }
        }
    }
}
