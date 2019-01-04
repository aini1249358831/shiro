package com.example.shiro2.DesignPattern.chain;

public class GeneralManager extends Leader {
    @Override
    public void getRequest(Employee employee) {

        if(employee.getDay()<10){
            System.out.println("总经理审批，请假原因为为"+employee.getReason());
        }
        else{
            nextLeader.getRequest(employee);
        }

    }
}
