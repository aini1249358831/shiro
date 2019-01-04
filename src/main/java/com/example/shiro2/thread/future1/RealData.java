package com.example.shiro2.thread.future1;

public class RealData implements Data {
    private String result = "";

    RealData(String param) {
        try {
            System.out.println("创建对象需要花一定的时间");
            Thread.sleep(3000);
            result= param+"查询出来的结果";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getRealData() {
        return result;
    }
}
