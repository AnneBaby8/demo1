package com.xsfh.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsfh.demo1.dto.StudentCreateDTO;
import com.xsfh.demo1.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> selectAll();
    void insert(StudentCreateDTO createDTO);
}
