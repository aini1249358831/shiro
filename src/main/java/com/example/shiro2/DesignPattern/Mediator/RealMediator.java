package com.example.shiro2.DesignPattern.Mediator;

public class RealMediator implements Mediator {

    private ColleugeA colleugeA;
    private ColleugeB colleugeB;

    public ColleugeA getColleugeA() {
        return colleugeA;
    }

    public void setColleugeA(ColleugeA colleugeA) {
        this.colleugeA = colleugeA;
    }

    public ColleugeB getColleugeB() {
        return colleugeB;
    }

    public void setColleugeB(ColleugeB colleugeB) {
        this.colleugeB = colleugeB;
    }

    @Override
    public void connect(String content, Colleuge colleuge) {
        if(colleuge==colleugeA){
            colleugeB.getMessage(content);
        }
        else{
            colleugeA.getMessage(content);
        }


    }
}
