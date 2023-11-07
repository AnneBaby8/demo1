package com.xsfh.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsfh.demo1.dto.OrderCreateDTO;
import com.xsfh.demo1.entity.Order;

import java.util.List;

public interface OrderService extends IService<Order> {

    List<Order> selectAllByNo(String orderNo, String orderSize);

    void inserOrder(OrderCreateDTO orderCreateDTO);

    void insertOrderList();

}
