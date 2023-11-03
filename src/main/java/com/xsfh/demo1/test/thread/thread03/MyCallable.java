package com.xsfh.demo1.test.thread.thread03;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 通过Executors和Callable接口实现有返回值的线程
 */
public class MyCallable implements Callable<String> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {//方法内为线程实现逻辑
        return name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建一个固定线程池
         ExecutorService pool = Executors.newFixedThreadPool(5);
        //2.创建一饿future集合，存放结果
         ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //3.创建一个有返回值的线程实例
            MyCallable  callable = new MyCallable("hello："+i);
            //4.提交线程，并将Future对象保存到future list中
            Future<String> future = pool.submit(callable);
            futures.add(future);
        }
        //5.关闭线程池
        pool.shutdown();
        //6.遍历所有运行结果
        for (Future future : futures) {
            System.out.println(future.get().toString());
        }

    }
}
