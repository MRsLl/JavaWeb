package com.atguigu.abstractfactory;

public abstract class Shoes {
    Face face;
    Bottom bottom;

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }
}
