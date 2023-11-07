package com.xsfh.demo1.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xsfh.demo1.bo.ItemBO;
import com.xsfh.demo1.entity.Item;
import com.xsfh.demo1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品模块 （控制器）
 */
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("test1")
    private String getStr1(){
        return "返回的是一个字符串哦";
    }

    /**
     * 根据订单id获取商品详情
     * @return
     */
    @GetMapping("selectAllByOrderId")
    public List<Item> selectAllByOrderId(int orderId){
        return itemService.selectAllByOrderId(orderId);
    }

    /**
     * 根据订单id查询数据（分页查询）
     */
    @GetMapping("selectPageByOrderId")
    public IPage<Item> selectAllByPage(ItemBO itemBO){
        return itemService.selectAllByPage(itemBO);
    }

}
