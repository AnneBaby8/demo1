package com.xsfh.demo1.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderVo {

    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField(value = "order_no")
    private String orderNo;

    @TableField(value = "order_size")
    private int orderSize;

    @TableField(value = "order_channel")
    private int orderChannel;

    @TableField(value = "order_status")
    private int orderStatus;

    @TableField(value = "order_price")
    private BigDecimal orderPrice;

    @TableField(value = "order_no")
    private String storeNo;

    @TableField(value = "shop_no")
    private String shopNo;

    @TableField(value = "shop_name")
    private String shopName;

    @TableField(value = "user_id")
    private int userId;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_phone")
    private String userPhone;

    @TableField(value = "user_address")
    private String userAddress;
}
