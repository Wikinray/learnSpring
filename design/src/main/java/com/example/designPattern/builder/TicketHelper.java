package com.example.designPattern.builder;

public class TicketHelper {

    public void buildAdult (String info) {
        System.err . println ( "构建成年人票逻辑：" + info);
    }

    public void buildBaby (String info) {
        System.err . println ( "构建儿童无座票：" + info);
    }

    public void buildChild (String info) {
        System.err . println ( "构建儿童有座票：" + info);
    }

    public void buildOld (String info) {
        System.err . println ( "构建老人票：" + info);
    }

    public void buildSoldier (String info) {
        System.err . println ( "构建军人票：" + info);
    }
}
