package com.example.shiro2.thread.future;

public class RealData implements Data {
    String result = "";


    public RealData initRealData(String param) throws InterruptedException {
        System.out.println("这个过程很耗时间");
        Thread.sleep(3000);
        result = param+"acd...";
        return this;
    }


    @Override
    public String getRealData() {
        return result;
    }
}
