package com.xsfh.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsfh.demo1.entity.Item;

import java.util.List;

public interface ItemService extends IService<Item> {
    List<Item> selectAllByOrderId(int orderId);
}
