package com.xsfh.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xsfh.demo1.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentDao extends BaseMapper<Student> {
    List<Student> selectAll();
}
