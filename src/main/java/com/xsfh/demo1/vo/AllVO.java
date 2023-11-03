package com.xsfh.demo1.vo;

import com.xsfh.demo1.entity.Item;
import com.xsfh.demo1.entity.Order;
import com.xsfh.demo1.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class AllVO {
    private List<Item> itemList;
    private List<Order> orderList;
    private List<Student> studentList;
    private long time;
}
