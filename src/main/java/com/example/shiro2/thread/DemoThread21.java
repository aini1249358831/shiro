package com.example.shiro2.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class DemoThread21 {
    public static void main(String[] args) {
        final SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(synchronousQueue.poll(2, TimeUnit.SECONDS));
                    System.out.println(synchronousQueue.poll(2, TimeUnit.SECONDS));
                    System.out.println(synchronousQueue.poll(2, TimeUnit.SECONDS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronousQueue.put(2);
                    synchronousQueue.offer(1,2,TimeUnit.SECONDS);
                    synchronousQueue.offer(2,2,TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t1").start();




    }
}
