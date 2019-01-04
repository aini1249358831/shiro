package com.example.shiro2.thread.future1;

public class FutureData implements Data {
    private RealData realData;
    private boolean isReady;

    synchronized void setRealData(RealData realData) {
        if(isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        notify();
    }

    @Override
    public synchronized String getRealData() {
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
