package com.xsfh.demo1.controller;

import com.xsfh.demo1.createDTO.StudentCreateDTO;
import com.xsfh.demo1.entity.Student;
import com.xsfh.demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("selectAll")
    public List<Student> selectAll(){
        return studentService.list();
    }

    @PostMapping("insert")
    public void insert(StudentCreateDTO createDTO){
        studentService.insert(createDTO);
    }
}
