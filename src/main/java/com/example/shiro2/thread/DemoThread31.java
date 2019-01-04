package com.example.shiro2.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DemoThread31 {
   private ReentrantLock lock = new ReentrantLock(true);
   private Condition condition = lock.newCondition();

    private void run1() throws InterruptedException {
        try{
            lock.lock();
            System.out.println(lock.getHoldCount());
            System.out.println("进入run1方法");
            Thread.sleep(1000);
            condition.await();
            System.out.println("run1方法执行结束");
        }

        finally{
            lock.unlock();
        }



    }
    private void run2() throws InterruptedException {
        try{
            lock.lock();
            System.out.println("进入run2方法");
            Thread.sleep(1000);
            condition.signal();
            System.out.println("run2方法发出唤醒");
            System.out.println("run2方法执行结束");
        }

        finally{
            lock.unlock();
        }



    }

    public static void main(String[] args) {
        DemoThread31 thread31 = new DemoThread31();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread31.run1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread31.run2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }



}
