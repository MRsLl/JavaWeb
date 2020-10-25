package com.atguigu.factorymethod;

public class SportsShoesFactory implements ShoeFactory{
    @Override
    public Shoe getShoes() {
        return new SportShoes();
    }
}
