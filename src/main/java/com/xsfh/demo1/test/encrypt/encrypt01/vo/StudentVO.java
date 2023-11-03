package com.xsfh.demo1.test.encrypt.encrypt01.vo;

import com.xsfh.demo1.test.encrypt.encrypt01.annotation.DecryptField;
import com.xsfh.demo1.test.encrypt.encrypt01.enums.DesensitizationEnum;
import lombok.Data;

@Data
public class StudentVO {

    private int id;

    @DecryptField(value = DesensitizationEnum.name)
    private String stuName;

    private int stuAge;
}
