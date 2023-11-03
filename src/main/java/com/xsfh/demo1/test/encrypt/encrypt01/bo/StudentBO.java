package com.xsfh.demo1.test.encrypt.encrypt01.bo;

import com.xsfh.demo1.test.encrypt.encrypt01.annotation.EncryptField;
import lombok.Data;

@Data
public class StudentBO {
    @EncryptField
    private String name;
    @EncryptField
    private String address;
}
