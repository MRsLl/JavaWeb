package com.atguigu.abstractfactory;


public abstract class ShoesAbstractFactory {
    public abstract  Face createFace();
    public abstract Bottom createBottom();

    public  Shoes create() {
        Shoes shoes = new SportsShoes();
        shoes.setFace(createFace());
        shoes.setBottom(createBottom());

        return shoes;
    }
}
