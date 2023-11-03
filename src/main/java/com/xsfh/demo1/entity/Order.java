package com.xsfh.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(value = "ordergoods")
public class Order {
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

    @TableField(value = "store_no")
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

    public Order() {
    }

    public Order(int id, String orderNo, int orderSize, int orderChannel, int orderStatus, BigDecimal orderPrice, String storeNo, String shopNo, String shopName, int userId, String userName, String userPhone, String userAddress) {
        this.id = id;
        this.orderNo = orderNo;
        this.orderSize = orderSize;
        this.orderChannel = orderChannel;
        this.orderStatus = orderStatus;
        this.orderPrice = orderPrice;
        this.storeNo = storeNo;
        this.shopNo = shopNo;
        this.shopName = shopName;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    public int getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(int orderChannel) {
        this.orderChannel = orderChannel;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
