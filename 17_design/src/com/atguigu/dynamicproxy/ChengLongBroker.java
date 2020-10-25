package com.atguigu.dynamicproxy;

public class ChengLongBroker implements Show {
    ChengLong chengLong;

    public ChengLongBroker(ChengLong chengLong) {
        this.chengLong = chengLong;
    }


    @Override
    public String show(int money, String str) {
        System.out.println("经纪人谈钱");
        String result = chengLong.show(money, str);
        System.out.println("经纪人收尾");
        return result;
    }
}
