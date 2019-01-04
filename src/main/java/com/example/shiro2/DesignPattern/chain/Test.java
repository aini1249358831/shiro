package com.example.shiro2.DesignPattern.chain;

public class Test {
    public static void main(String[] args) {

        Employee employee =  new Employee(2,"肚子不舒服");
        Leader leader =  new DirectorLeader();
        Leader leader1 =  new GeneralManager();
        Leader leader2 =  new Ceo();
        leader.nextLeader = leader1;
        leader1.nextLeader = leader2;
        leader.getRequest(employee);




    }

}
