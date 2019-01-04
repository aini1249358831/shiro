package com.example.shiro2.thread.future1;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Data data = client.request("userId");
        System.out.println("我先去做其他的事情");

       /* String realData = data.getRealData();
        System.out.println(realData);*/


    }
}
