package com.atguigu.abstractfactory;


public class ShoeFactory {
    public static Face createFace() {
        return new Face1();
    }
    public static Bottom createBottom() {
        return new Bottom1();
    }

    public static Shoes create() {
        Shoes shoes = new SportsShoes();
        shoes.setFace(createFace());
        shoes.setBottom(createBottom());

        return shoes;
    }
}
