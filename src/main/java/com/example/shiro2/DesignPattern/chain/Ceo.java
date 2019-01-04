package com.example.shiro2.DesignPattern.chain;

public class Ceo extends Leader {
    @Override
    public void getRequest(Employee employee) {
        if(employee.getDay()<30){
            System.out.println("ceo审批，请假原因为为"+employee.getReason());
        }
        else{
            System.out.println("请那么多天直接开除");
    }

    }
}
