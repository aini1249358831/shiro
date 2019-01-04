package com.example.shiro2.DesignPattern.Mediator;

public class Colleuge {
    protected String name;
    protected Mediator mediator;

    public Colleuge(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
