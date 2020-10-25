package com.atguigu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static <T>T createJdkProxy(T target, InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler);
    }
}
