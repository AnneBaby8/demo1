package com.xsfh.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xsfh.demo1.dto.StudentCreateDTO;
import com.xsfh.demo1.dao.StudentDao;
import com.xsfh.demo1.entity.Student;
import com.xsfh.demo1.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao,Student> implements StudentService {
    @Override
    public List<Student> selectAll() {
        log.info("-----开始查询学生信息-----");
        //List<Student> students = this.selectAll();
       return null;
        // return students;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(StudentCreateDTO createDTO) {
        log.info("---开始插入数据---,数据为：[{}]",createDTO);
        Student student = new Student();
        BeanUtils.copyProperties(createDTO,student);
        baseMapper.insert(student);
    }
}
