package com.example.designPattern.builder;

public class TicketTest {
    public static void main(String[] args){
        TicketHelper helper=new TicketHelper();
        helper.buildAdult("全价票");
        helper.buildBaby("无票");
        helper.buildChild("半价票");
        helper.buildOld("老人票");
        helper.buildSoldier("军人票");

        TicketBuilder.builder(helper);
    }
}
