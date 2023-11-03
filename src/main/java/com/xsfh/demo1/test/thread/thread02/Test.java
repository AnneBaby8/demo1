package com.xsfh.demo1.test.thread.thread02;

public class Test {
    public static void main(String[] args) {
        final Thread02 thread02 = new Thread02();
        final Thread thread = new Thread(thread02);
        thread.start();
    }
}
