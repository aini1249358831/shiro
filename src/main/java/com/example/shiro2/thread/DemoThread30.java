package com.example.shiro2.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoThread30 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger = new Exchanger<>();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "aaa";
                System.out.println(Thread.currentThread().getName()+"线程交换后的数据为"+data1);
                try {
                    Thread.sleep((long) Math.random()*1000);
                    String exchange = exchanger.exchange(data1);
                    System.out.println(Thread.currentThread().getName()+"线程交换后的数据为"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "ddd";
                System.out.println(Thread.currentThread().getName()+"线程交换后的数据为"+data1);
                try {
                    Thread.sleep((long) Math.random()*1000);
                    String exchange = exchanger.exchange(data1);
                    System.out.println(Thread.currentThread().getName()+"线程交换后的数据为"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        pool.shutdown();




    }
}
