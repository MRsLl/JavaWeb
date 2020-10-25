package com.atguigu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BuyInvocationHandler implements InvocationHandler {
    private Object target;

    public BuyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.做一些增强操作
        System.out.println("房屋中介替顾客找房，谈价钱");
        Object result = method.invoke(target, args);
        System.out.println("房屋中介收尾");
        return result;
    }
}
