package com.xsfh.demo1.test.generics.genertic03;

/**
 * 泛型类
 */
public class GenericClass<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        final GenericClass<String> stringGeneric = new GenericClass<>();
        stringGeneric.setT("嘎嘎");
        System.out.println(stringGeneric.getT());

        final GenericClass<Integer> intGeneric = new GenericClass<>();
        intGeneric.setT(1);
        System.out.println(intGeneric.getT());
    }
}
