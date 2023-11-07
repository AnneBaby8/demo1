package com.xsfh.demo1.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xsfh.demo1.bo.ItemBO;
import com.xsfh.demo1.entity.Item;

import java.util.List;

public interface ItemService extends IService<Item> {
    List<Item> selectAllByOrderId(int orderId);

    IPage<Item> selectAllByPage(ItemBO itemBO);
}
