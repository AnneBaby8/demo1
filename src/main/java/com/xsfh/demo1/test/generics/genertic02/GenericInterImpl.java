package com.xsfh.demo1.test.generics.genertic02;

import com.xsfh.demo1.test.generics.genertic02.GenericInterface;

public class GenericInterImpl implements GenericInterface<String> {
    @Override
    public String getResult() {
        return "hello 呀";
    }
}
