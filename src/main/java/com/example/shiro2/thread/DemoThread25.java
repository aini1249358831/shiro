package com.example.shiro2.thread;

import java.util.concurrent.CountDownLatch;

public class DemoThread25 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Demo1 demo1 = new Demo1(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(demo1,"demo1").start();
        }
        latch.await();
        System.out.println(System.currentTimeMillis()-start);


    }
}
class Demo1 implements Runnable{
    private CountDownLatch countDownLatch;

    public Demo1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        try {
            synchronized (this){
                for (int i = 0; i < 500000000; i++) {

                    /*if(i%2==0){
                        *//*System.out.print(i);*//*
                    }*/
                }
            }

        }
        finally {

            countDownLatch.countDown();
        }


    }
}

