package com.xsfh.demo1.dto;

import com.xsfh.demo1.test.encrypt.encrypt01.annotation.EncryptField;
import lombok.Data;

@Data
public class StudentCreateDTO {
    @EncryptField
    private String stuName;

    @EncryptField
    private int stuAge;
}
