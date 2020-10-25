package com.atguigu.factorymethod;

public class LeatherShoesFactory implements ShoeFactory{
    @Override
    public Shoe getShoes() {
        return new LeatherShoes();
    }
}
