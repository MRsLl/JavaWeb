package com.atguigu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ShowInvocationHandler implements InvocationHandler {
    private Object target;

    public ShowInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.做一些增强操作
        System.out.println("经纪人谈钱" + args[0]);
        Object result = method.invoke(target, args);
        System.out.println("经纪人收尾");
        return result;
    }
}
