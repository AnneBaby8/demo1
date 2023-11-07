package com.xsfh.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.xsfh.demo1.dto.OrderCreateDTO;
import com.xsfh.demo1.dao.OrderDao;
import com.xsfh.demo1.entity.Order;
import com.xsfh.demo1.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Override
    public List<Order> selectAllByNo(String orderNo, String orderSize) {
        if(StringUtils.isEmptyOrWhitespaceOnly(orderNo) ){
            throw new RuntimeException("商品编号不能为空！");
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(orderSize) ){
            throw new RuntimeException("商品小号不能为空！");
        }
        List<Order> orders = baseMapper.selectAllByNo(orderNo, orderSize);
        return orders;
    }

    @Override
    public void inserOrder(OrderCreateDTO orderCreateDTO) {
        log.info("开始增加订单信息，订单的信息为：[{}]",orderCreateDTO);
        if(orderCreateDTO == null){
            throw new RuntimeException("订单信息为空");
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderCreateDTO,order);
        //订单编号
        order.setOrderNo("111");
        order.setStoreNo("111");
        baseMapper.insert(order);
    }

    @Override
    @Transactional
    public void insertOrderList() {
        for (int i = 2; i <= 1000; i++) {
            Order order = new Order();
            order.setOrderNo("001");
            order.setOrderSize(i);

            BigDecimal price = new BigDecimal(100+i);
            order.setOrderPrice(price);

            order.setOrderChannel(1);
            order.setOrderStatus(1);
            order.setShopNo("001");
            order.setShopName("盒马鲜生");
            order.setUserId(1);
            order.setUserName("小明");
            order.setUserPhone("123456");
            order.setUserAddress("北京");
            baseMapper.insert(order);
        }
    }
}
