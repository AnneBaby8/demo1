package com.xsfh.demo1.test.encrypt.encrypt01.controller;

import com.xsfh.demo1.createDTO.StudentCreateDTO;
import com.xsfh.demo1.service.StudentService;
import com.xsfh.demo1.test.encrypt.encrypt01.annotation.Encryption;
import com.xsfh.demo1.test.encrypt.encrypt01.bo.UserBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 加密 Controller
 */
@RestController
@RequestMapping("/encrypt")
@Slf4j
public class EncryptController {
    @Autowired
    private StudentService studentService;
    /**
     * 简单案例
     * @param user
     * @return
     */
    @PostMapping("/v1")
    @Encryption  // 切入点
    public UserBO insert(@RequestBody UserBO user) {
        log.info("加密后对象：{}", user);
        return user;
    }

    /**
     * 添加一个学生，将加密后的数据存储至数据库
     */
    @PostMapping("insetStudent")
    @Encryption
    public void insertStudent(@RequestBody StudentCreateDTO createDTO){
        log.info("学生信息为：[{}]",createDTO);
        studentService.insert(createDTO);
    }

}

