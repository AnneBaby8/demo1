package com.xsfh.demo1.test.outerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * 静态内部类
 */
@Slf4j
public class OuterClass01 {
    private static String className = "aaa";
    //静态内部类
    public static class StaticInnerClass{
        public void getClassName(){
            log.info("class name is [{}] ",className);
        }
    }
    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.getClassName();
    }

}
