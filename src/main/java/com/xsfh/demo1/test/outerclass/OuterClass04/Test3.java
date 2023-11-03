package com.xsfh.demo1.test.outerclass.OuterClass04;

public class Test3 {
    public void TestTest3(Parent parent){
        parent.f();
    }

    public static void main(String[] args) {
         Test3 test3 = new Test3();
        test3.TestTest3(new Parent() {
            @Override
            public void f() {
                System.out.println("匿名内部类");
            }
        });
    }
}
