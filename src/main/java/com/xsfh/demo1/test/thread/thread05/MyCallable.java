package com.xsfh.demo1.test.thread.thread05;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private Integer num;

    public MyCallable(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        return num+1;
    }
}
