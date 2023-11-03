package com.xsfh.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xsfh.demo1.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    List<Order> selectAllByNo(@Param(value = "orderNo") String orderNo, @Param(value = "orderSize") String orderSize);
}
