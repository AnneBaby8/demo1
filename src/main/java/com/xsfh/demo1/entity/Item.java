package com.xsfh.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(value = "item")
public class Item {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField(value = "item_no")
    private String itemNo;

    @TableField(value = "item_name")
    private String itemName;

    @TableField(value = "item_picture")
    private String itemPicture;

    @TableField(value = "item_price")
    private BigDecimal itemPrice;

    @TableField(value = "item_num")
    private int itemNum;

    @TableField(value = "item_total_price")
    private BigDecimal itemTotalPrice;

    @TableField(value = "order_id")
    private int orderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public BigDecimal getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(BigDecimal itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Item(int id, String itemNo, String itemName, String itemPicture, BigDecimal itemPrice, int itemNum, BigDecimal itemTotalPrice, int orderId) {
        this.id = id;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemPicture = itemPicture;
        this.itemPrice = itemPrice;
        this.itemNum = itemNum;
        this.itemTotalPrice = itemTotalPrice;
        this.orderId = orderId;
    }

    public Item() {
    }
}
