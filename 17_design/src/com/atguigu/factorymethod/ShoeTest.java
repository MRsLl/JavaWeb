package com.atguigu.factorymethod;

public class ShoeTest {
    public static void main(String[] args) {
        ShoeFactory sportShoesFactory = new SportsShoesFactory();
        sportShoesFactory.getShoes();

        ShoeFactory leatherShoesFactory = new LeatherShoesFactory();
        leatherShoesFactory.getShoes();
    }
}
