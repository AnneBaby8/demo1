package com.xsfh.demo1.test.encrypt.encrypt01.bo;

import com.xsfh.demo1.test.encrypt.encrypt01.annotation.EncryptField;

import java.lang.reflect.Field;

// 用户信息新增实体类
public class UserBO {
    @EncryptField
    private String name;

    @EncryptField
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

    public UserBO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserBO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
//
//    public static void main(String[] args) throws IllegalAccessException {
//        UserBO userBO = new UserBO("周传雄","湖北省武汉市");
//        Field[] fields = userBO.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            boolean annotationPresent = field.isAnnotationPresent(EncryptField.class);
//            if(annotationPresent){
//                // 当前字段内容不为空
//                if(field.get(userBO) != null){
//                    // 这里对字段内容进行加密
//                    Object obj = encrypt(field.get(userBO));
//                    // 字段内容加密过后 通过反射重新赋给该字段
//                    field.set(userBO, obj);
//                }
//            }
//        }
//        System.out.println(userBO);
//    }

    public static Object encrypt(Object obj){
        return "加密: " + obj;
    }
}