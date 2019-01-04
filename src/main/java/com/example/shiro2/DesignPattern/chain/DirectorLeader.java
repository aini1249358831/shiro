package com.example.shiro2.DesignPattern.chain;

public class DirectorLeader extends Leader {

    @Override
    public void getRequest(Employee employee) {
        if(employee.getDay()<3){
            System.out.println("主任审批，请假原因为为"+employee.getReason());
        }
        else{
            nextLeader.getRequest(employee);
        }
    }
}
