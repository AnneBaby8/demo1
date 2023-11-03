package com.xsfh.demo1.test.generics.genertic01;

import com.xsfh.demo1.entity.Item;

import java.util.Date;

/**
 * 泛型方法
 */
public class GenericMethod {
    public static void main(String[] args) {
        generics(1,"111",new Item());
    }

    private static <T>void generics(T ... inputArray) {
        for (T type : inputArray) {
            if(type instanceof Date){
                System.out.println("this is 时间类型");
            }else if(type instanceof Item){
                System.out.println("this is 商品类型");
            }else if(type instanceof String){
                System.out.println("this is 字符串");
            }else if(type instanceof Integer){
                System.out.println("this is 整数");
            }else if(type instanceof Byte){
                System.out.println("this is 字节");
            }else if(type instanceof Short){
                System.out.println("this is 断");
            }else if(type instanceof Long){
                System.out.println("this is 长");
            }
        }
    }
}
