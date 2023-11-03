package com.xsfh.demo1.test.thread.thread01;

public class Thread01 extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+"    开启一个线程");
    }
}
