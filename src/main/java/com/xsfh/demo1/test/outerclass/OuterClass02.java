package com.xsfh.demo1.test.outerclass;
import lombok.extern.slf4j.Slf4j;

/**
 * 成员内部类
 */
@Slf4j
public class OuterClass02 {
    private String aaa = "xiaoming";
    private int age = 17;
    public class InnerClass{
        public void getInfo(){
            log.info("姓名为：[{}],年纪为：[{}]",aaa,age);
        }

    }
}
