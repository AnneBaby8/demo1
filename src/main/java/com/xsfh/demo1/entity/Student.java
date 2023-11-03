package com.xsfh.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "student")
public class Student {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "stu_name")
    private String stuName;

    @TableField(value = "stu_age")
    private int stuAge;
}
