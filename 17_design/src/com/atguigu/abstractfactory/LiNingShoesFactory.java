package com.atguigu.abstractfactory;

public class LiNingShoesFactory extends ShoesAbstractFactory{
    @Override
    public Face createFace() {
        return new Face2();
    }

    @Override
    public Bottom createBottom() {
        return new Bottom2();
    }
}
