package com.xsfh.demo1.test.outerclass.OuterClass04;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test2 {
    public static void main(String[] args) {
        Niming niming = new Niming();

        niming.Niming(new MyInterface() {
            @Override
            public void f() {
                System.out.println("匿名内部类");
            }
        });

    }
}
