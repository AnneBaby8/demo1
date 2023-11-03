package com.xsfh.demo1.test.encrypt.encrypt01.vo;

import com.xsfh.demo1.test.encrypt.encrypt01.annotation.DecryptField;
import com.xsfh.demo1.test.encrypt.encrypt01.enums.DesensitizationEnum;

import java.lang.reflect.Field;

// 用户信息返回实体类
public class UserDO {

    @DecryptField(DesensitizationEnum.name)
    private String name;

    @DecryptField(DesensitizationEnum.address)
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static void main(String[] args) throws IllegalAccessException {
        // 生成并初始化对象
        UserDO userDO = new UserDO("梦想是什么","湖北省武汉市");
        // 反射获取当前对象的所有字段
        Field[] fields = userDO.getClass().getDeclaredFields();
        // 遍历字段
        for (Field field : fields) {
            // 判断字段上是否存在@DecryptField注解
            boolean hasSecureField = field.isAnnotationPresent(DecryptField.class);
            // 存在
            if (hasSecureField) {
                // 暴力破解 不然操作不了权限为private的字段
                field.setAccessible(true);
                // 如果当前字段在userDo中不为空 即name,address字段有值
                if (field.get(userDO) != null) {
                    // 获取字段上注解的value值
                    DesensitizationEnum desensitizationEnum = field.getAnnotation(DecryptField.class).value();
                    // 控制台输出
                    System.out.println(desensitizationEnum);
                    // 根据不同的value值 我们可以对字段进行不同逻辑的脱敏 比如姓名脱敏-魏*,手机号脱敏-187****2275
                }
            }
        }
    }
}
