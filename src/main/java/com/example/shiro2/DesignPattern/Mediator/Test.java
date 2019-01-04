package com.example.shiro2.DesignPattern.Mediator;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new RealMediator();
        ColleugeA colleugeA = new ColleugeA("张三",mediator);
        ColleugeB colleugeB = new ColleugeB("李四", mediator);
        ((RealMediator) mediator).setColleugeA(colleugeA);
        ((RealMediator) mediator).setColleugeB(colleugeB);
        colleugeA.connect("我要出发了");
        colleugeB.connect("我等你");






    }
}
