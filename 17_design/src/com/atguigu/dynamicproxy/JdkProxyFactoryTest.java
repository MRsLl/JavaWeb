package com.atguigu.dynamicproxy;

public class JdkProxyFactoryTest {
    public static void main(String[] args) {
        ChengLong chengLong = new ChengLong();
        Show showProxy = JdkProxyFactory.createJdkProxy(chengLong, new ShowInvocationHandler(chengLong));
        showProxy.show(10000,"动态代理");

        Customer customer = new Customer();
        Buy buyProxy = JdkProxyFactory.createJdkProxy(customer,new BuyInvocationHandler(customer));
        buyProxy.Buy();
    }
}
