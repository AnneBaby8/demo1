package com.xsfh.demo1.controller;

import com.xsfh.demo1.dto.OrderCreateDTO;
import com.xsfh.demo1.entity.Order;
import com.xsfh.demo1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单模块
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询所有订单
     * @return
     */
    @GetMapping("selectAll")
    public List<Order> selectAll(){
        return orderService.list();
    }

    /**
     * 根据订单号和订单小号查询订单信息
     * @param orderNo 订单号
     * @param orderSize 订单小号
     * @return
     */
    @GetMapping("selectAllByNo")
    public List<Order> selectAllByNo(String orderNo, String orderSize){
        return orderService.selectAllByNo(orderNo,orderSize);
    }

    /**
     * 新增订单
     * @param orderCreateDTO 订单参数
     */
    @GetMapping("inset")
    public void  insertOrder(OrderCreateDTO orderCreateDTO){
        orderService.inserOrder(orderCreateDTO);
    }
    /**
     * 添加上百订单
     */
    @GetMapping("insertOrderList")
    public void insertOrderList(){
        orderService.insertOrderList();
    }
}
