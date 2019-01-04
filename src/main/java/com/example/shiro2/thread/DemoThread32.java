package com.example.shiro2.thread;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoThread32 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(7,7,0,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(2),new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 100; i++) {
            Mask mask = new Mask(i);
            pool.submit(mask);
        }
        pool.shutdown();


    }
}
class Mask implements Runnable{
    private int index = 0;

    public Mask(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"run------"+index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
