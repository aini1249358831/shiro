package com.example.shiro2.DesignPattern.Mediator;

public class ColleugeA extends Colleuge {
    public ColleugeA(String name, Mediator mediator) {
        super(name, mediator);
    }
    public void getMessage(String message){
        System.out.println(name+"获取到的信息为"+message);
    }
    public void connect(String meaasge){
        mediator.connect(meaasge,this);
    }


}
