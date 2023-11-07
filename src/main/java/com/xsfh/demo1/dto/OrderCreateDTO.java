package com.xsfh.demo1.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderCreateDTO {
    private String orderNo;

    private int orderChannel;

    private BigDecimal orderPrice;


    private String storeNo;

    private String shopNo;

    private String shopName;

    private int userId;

    private String userName;

    private String userPhone;

    private String userAddress;
}
