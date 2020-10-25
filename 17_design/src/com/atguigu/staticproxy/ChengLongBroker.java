package com.atguigu.staticproxy;

public class ChengLongBroker implements Show{
    ChengLong chengLong;

    public ChengLongBroker(ChengLong chengLong) {
        this.chengLong = chengLong;
    }

    @Override
    public void show() {
        System.out.println("经纪人谈钱");
        chengLong.show();
        System.out.println("经纪人收尾");
    }
}
