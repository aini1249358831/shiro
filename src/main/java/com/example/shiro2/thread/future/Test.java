package com.example.shiro2.thread.future;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        FutureController controller = new FutureController();
       Data userId = controller.handler("userId");
        String realData = userId.getRealData();
        System.out.println(realData);

    }
}
