package com.producer;


public class Records {
    public static String a = getA();
    private Value value;
    public void setValue(Value value) {
        this.value = value;
    }
    public Records(){
        System.out.println("records init");
    }
    public Value getValue() {
        return value;
    }
    private static String getA(){
        System.out.println("aaaaaaaa");
        return "aaaaaaaa";
    }
}
