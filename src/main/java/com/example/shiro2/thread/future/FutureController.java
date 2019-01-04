package com.example.shiro2.thread.future;

public class FutureController  {

    public Data handler( final String param){
        final FutureData futureData = new FutureData();


        new Thread(() -> {
            try {
                futureData.initRealData(param);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();




        return futureData;
    }





}
