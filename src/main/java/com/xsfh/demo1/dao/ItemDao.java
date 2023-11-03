package com.xsfh.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xsfh.demo1.entity.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemDao extends BaseMapper<Item> {
}
