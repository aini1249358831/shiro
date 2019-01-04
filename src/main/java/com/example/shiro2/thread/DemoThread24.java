package com.example.shiro2.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DemoThread24 {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2线程开始进行等待");
                try {
                    countDownLatch.await(2,TimeUnit.SECONDS);
                    System.out.println("t2线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        },"t2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t3线程开始进行等待");
                try {
                    countDownLatch.await(3,TimeUnit.SECONDS);
                    System.out.println("t3线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        },"t3").start();
        Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(countDownLatch.getCount());
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount());
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount());
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount());
            }
        },"t1").start();




    }
}
