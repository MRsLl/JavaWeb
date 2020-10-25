package com.atguigu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BuyProxyTest {
    static Customer customer = new Customer();

    public static void main(String[] args) {
        Buy proxy = (Buy) Proxy.newProxyInstance(
                customer.getClass().getClassLoader(),
                customer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("中介帮顾客找房，谈价格");
                        Object invoke = method.invoke(customer);
                        System.out.println("中介收尾");
                        return invoke;
                    }
                }
        );

        proxy.Buy();
    }
}
