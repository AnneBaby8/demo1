package com.xsfh.demo1.test.thread.thread01;

public class Test01 {
    public static void main(String[] args) {

        final Thread01 thread01 = new Thread01();
        thread01.start();//是一个native方法，用于操作系统启动一个新的线程 run：用于启动线程
    }
}
