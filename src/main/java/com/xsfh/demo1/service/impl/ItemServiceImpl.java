package com.xsfh.demo1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xsfh.demo1.bo.ItemBO;
import com.xsfh.demo1.dao.ItemDao;
import com.xsfh.demo1.entity.Item;
import com.xsfh.demo1.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemServiceImpl extends ServiceImpl<ItemDao, Item> implements ItemService {

    @Override
    public List<Item> selectAllByOrderId(int orderId) {
        if(String.valueOf(orderId).equals("")){
            throw new RuntimeException("订单编号不能空！");
        }
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Item::getOrderId,orderId);
        return null;
    }

    @Override
    public IPage<Item> selectAllByPage(ItemBO itemBO) {
        Page<Item> itemPage = new Page<>(itemBO.getPageNo(), itemBO.getPageSize());
        QueryWrapper<Item> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Item> queryWrapper = wrapper.lambda();
        queryWrapper.eq(Item::getOrderId,itemBO.getOrderId());
        IPage<Item> itemListPage = this.page(itemPage, queryWrapper);
        return itemListPage;
    }
}
