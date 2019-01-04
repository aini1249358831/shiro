package com.example.shiro2.thread;

public class MyThread implements Runnable {
    private static int count = 0;

    private static synchronized void add() throws InterruptedException {
        count++;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"---"+count);

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(),"thread1");
        Thread t2 = new Thread(new MyThread(),"thread2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try {
            add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
