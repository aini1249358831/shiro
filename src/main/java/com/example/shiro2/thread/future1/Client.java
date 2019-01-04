package com.example.shiro2.thread.future1;

public class Client {

    public Data request(final String param){
        final FutureData futureData = new FutureData();

        new Thread(() -> {
            RealData realData = new RealData(param);
            futureData.setRealData(realData);

        }).start();




    return futureData;
    }



}
