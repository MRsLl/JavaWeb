package com.atguigu.dynamicproxy;

public class ChengLong implements Show {

    @Override
    public String show(int money, String str) {
        System.out.println("成龙大哥表演");
        return str;
    }
}
