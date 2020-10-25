package com.atguigu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        ChengLong chengLong = new ChengLong();
        //获取指定类的所有接口
/*        for (Class<?> anInterface : chengLong.getClass().getInterfaces()){
            System.out.println(anInterface);
        }*/
        /**
         * 在jdk中反射包下有一个Proxy代理工具类.<br/>
         * 它可以帮我们根据任意的目标对象和接口产生一个代理类. <br/>
         * newProxyInstance()帮我们创建一个代理对象实例.<br/>
         *  第一个参数是目标对象的类加载器 <br/>
         *  第二个参数是目标对象和代理对象需要实现的接口 <br/>
         *  第三个参数是,代理对象方法增强的接口.实现类 <br/>
         *      InvocationHandler接口,在代理对象调用方法时,就会自动调用.
         */
        Show proxy = (Show) Proxy.newProxyInstance(
                chengLong.getClass().getClassLoader(),
                chengLong.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * invoke() 表示代理对象的所有方法实现体
                     * @param proxy 第一个参数，是代理对象实例
                     * @param method 第二个参数，它是调用方法的反射对象
                     * @param args 第三个参数，调用代理方法时传递进来的实参
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println(proxy);
//                        System.out.println(method);
//                        System.out.println(args);
                        //1.做一些增强操作
                        System.out.println("经纪人谈钱" + args[0]);
                        //2.执行目标对象方法
                        /**
                         * method.invoke()方法返回值就是调用目标方法的返回值
                         */
                        Object result = method.invoke(chengLong, args);
                        System.out.println("经纪人收尾");
                        return result;
                    }
                }
        );

        String result = proxy.show(1000,"动态代理");
        System.out.println("代理方法的返回值：" + result);
    }
}
