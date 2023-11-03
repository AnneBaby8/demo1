package com.xsfh.demo1.test.encrypt.encrypt01.controller;

import com.xsfh.demo1.entity.Student;
import com.xsfh.demo1.service.StudentService;
import com.xsfh.demo1.test.encrypt.encrypt01.vo.StudentVO;
import com.xsfh.demo1.test.encrypt.encrypt01.vo.UserDO;
import com.xsfh.demo1.test.encrypt.encrypt01.annotation.Decryption;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *解密 Controller
 */
@RestController
@RequestMapping("/decrypt")
public class DecryptController {
    @Autowired
    private StudentService studentService;
    /**
     * 简单案例
     * @return
     */
    @GetMapping("/v1")
    @Decryption
    public UserDO decrypt() {
        return new UserDO("7c29e296e92893476db5f9477480ba7f", "b5c7ff86ac36c01dda45d9ffb0bf73194b083937349c3901f571d42acdaa7bae");
    }
    /**
     * 查询学生信息
     */
    @GetMapping("selectOneById")
    @Decryption
    public StudentVO selectOneById(@RequestParam int id){
        Student student = studentService.getById(id);
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        return studentVO;
    }
}

