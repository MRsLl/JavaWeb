package com.atguigu.staticproxy;

public class ShowTest {
    public static void main(String[] args) {
        ChengLong chengLong = new ChengLong();
//        chengLong.show();
        ChengLongBroker broker = new ChengLongBroker(chengLong);
        broker.show();
    }
}
