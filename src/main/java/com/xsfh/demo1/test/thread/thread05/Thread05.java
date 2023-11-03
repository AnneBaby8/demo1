package com.xsfh.demo1.test.thread.thread05;

import com.xsfh.demo1.core.wrapper.ResultData;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread05 {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ArrayList<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            Future<Integer> result = pool.submit(new MyCallable(Integer.valueOf(i)));
            list.add(result);
        }
        System.out.println("===线程运行结束===");
        for (Future future : list) {
            System.out.println(future.get());
        }

    }
}
