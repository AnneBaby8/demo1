package com.xsfh.demo1.test.thread.thread07;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xsfh.demo1.entity.Item;
import com.xsfh.demo1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable01 implements Callable<Integer>{
    private Integer orderId;

    public MyCallable01(Integer orderId) {
        this.orderId = orderId;
    }

    @Autowired
    private ItemService itemService;

    @Override
    public Integer call() throws Exception {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Item> itemQueryLambda = queryWrapper.lambda();
        itemQueryLambda.eq(Item::getOrderId,1);
        List<Item> list = itemService.list(itemQueryLambda);
        return 1;
    }
}
