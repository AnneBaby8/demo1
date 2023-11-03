package com.xsfh.demo1.test.thread.thread07;

import com.xsfh.demo1.entity.Item;
import com.xsfh.demo1.entity.Order;
import com.xsfh.demo1.entity.Student;
import com.xsfh.demo1.service.ItemService;
import com.xsfh.demo1.service.OrderService;
import com.xsfh.demo1.service.StudentService;
import com.xsfh.demo1.test.thread.thread01.Thread01;
import com.xsfh.demo1.vo.AllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 */
@RestController
@RequestMapping("thread")
public class Thread07 {
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StudentService studentService;

    /**
     * 不使用线程池(查询数据)
     * @return
     */
    @GetMapping("getAllInfo")
    public AllVO getAllInfo() {
        long startTime = System.currentTimeMillis();
        List<Item> itemList = itemService.list();
        List<Order> orderList = orderService.list();
        List<Student> studentList = studentService.list();
        AllVO allVO = new AllVO();
        allVO.setItemList(itemList);
        allVO.setOrderList(orderList);
        allVO.setStudentList(studentList);
        long endTime = System.currentTimeMillis();
        allVO.setTime(endTime-startTime);
        return allVO;
    }
    /**
     * 使用线程池（使用CompletableFuture并行查询数据）
     */
    @GetMapping("getAllInfoByCompletableFuture")
    public AllVO getAllInfoByCompletableFuture() {
        long startTime = System.currentTimeMillis();
        //初始化返回结果
        AllVO result = new AllVO();
        //初始化线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //初始化线程数量
        CompletableFuture[] futures = new CompletableFuture[3];

        futures[0] = CompletableFuture.runAsync(() -> {
            List<Item> itemList = itemService.list();
            result.setItemList(itemList);
        },pool);

        futures[1] = CompletableFuture.runAsync(() -> {
            List<Order> orderList = orderService.list();
            result.setOrderList(orderList);
        },pool);

        futures[2] = CompletableFuture.runAsync(() -> {
            List<Student> studentList = studentService.list();
            result.setStudentList(studentList);
        },pool);

        long endTime = System.currentTimeMillis();
        result.setTime(endTime-startTime);
        //allOf方法，当所有给定的任务完成后，返回一个全新的已完成CompletableFuture
        CompletableFuture.allOf(futures).join();
        return result;
    }

    /**
     * 使用线程池（并行查询数据）
     */
    @GetMapping("getAllInfoByThread")
    public AllVO getAllInfoByThread() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        AllVO allVO = new AllVO();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<List<Item>> itemListFuture = pool.submit(new Callable<List<Item>>() {
            @Override
            public List<Item> call() throws Exception {
                List<Item> list = itemService.list();
                return list;
            }
        });


        Future<List<Order>> orderListFuture = pool.submit(new Callable<List<Order>>() {
            @Override
            public List<Order> call() throws Exception {
                List<Order> list = orderService.list();
                return list;
            }
        });

        Future<List<Student>> studentListFuture = pool.submit(new Callable<List<Student>>() {
            @Override
            public List<Student> call() throws Exception {
                List<Student> list = studentService.list();
                return list;
            }
        });

        allVO.setItemList(itemListFuture.get());
        allVO.setOrderList(orderListFuture.get());
        allVO.setStudentList(studentListFuture.get());
        long endTime = System.currentTimeMillis();
        allVO.setTime(endTime-startTime);
        return allVO;
    }

    /**
     * 测试线程池的优先级
     */
    @GetMapping("testThread")
    public void testThread(){
        Thread thread01 = new Thread01();
        Thread thread02 = new Thread01();
        Thread thread03 = new Thread01();
        thread01.start();
        thread02.start();
        thread03.start();

    }

    /**
     * 执行有顺序线程（将两个异步计算合并为一个，这两个异步计算之间相互独立，同时第二个又依赖于第一个的结果。）
     * 1.先查询有什么订单
     * 2.根据订单id查询商品信息
     */
    @GetMapping("testSequenceThreadByComplateFuture")
    public void testSequenceThreadByComplateFuture(){
        String orderNo = "001";

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 1,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(100),new ThreadPoolExecutor.CallerRunsPolicy());

        AllVO allVO = new AllVO();
        CompletableFuture.supplyAsync(()->{
            List<Order> orderList = orderService.selectAllByNo(orderNo,"1");
            allVO.setOrderList(orderList);
            return orderList;
        },pool).thenApply((result)->{
            List<Item> itemList = itemService.list();
            allVO.setItemList(itemList);
            return itemList;
        }).thenRun(()->{
            List<Student> studentList = studentService.list();
            allVO.setStudentList(studentList);
        });



    }

}
