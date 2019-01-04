package com.example.shiro2.thread.future;

public class FutureData implements Data {
    private RealData realData;
    private boolean isReady = false;



    synchronized void initRealData(String param) throws InterruptedException {
        realData = new RealData().initRealData(param);
        isReady = true;
        notify();
    }
    public synchronized String getRealData()  {
        if(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return realData.getRealData();
    }



}
