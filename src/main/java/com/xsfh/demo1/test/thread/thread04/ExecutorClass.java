package com.xsfh.demo1.test.thread.thread04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于线程池
 */
public class ExecutorClass {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"is running");
                }
            });
        }

    }
}
