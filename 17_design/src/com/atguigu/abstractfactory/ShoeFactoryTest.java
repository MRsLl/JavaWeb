package com.atguigu.abstractfactory;

public class ShoeFactoryTest {
    public static void main(String[] args) {
//        ShoeFactory.create();
        ShoesAbstractFactory shoesAbstractFactory = new LiNingShoesFactory();
        shoesAbstractFactory.create();
    }
}
