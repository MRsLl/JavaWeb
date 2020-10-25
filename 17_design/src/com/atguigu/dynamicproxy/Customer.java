package com.atguigu.dynamicproxy;

public class Customer implements Buy{
    @Override
    public void Buy() {
        System.out.println("顾客买房子");
    }
}
