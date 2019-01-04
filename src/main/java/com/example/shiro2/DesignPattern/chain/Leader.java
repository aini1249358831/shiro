package com.example.shiro2.DesignPattern.chain;

public abstract class Leader {
     Leader nextLeader;
    public abstract void getRequest(Employee employee);

}
