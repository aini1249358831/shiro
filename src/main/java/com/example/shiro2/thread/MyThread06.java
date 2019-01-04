package com.example.shiro2.thread;

public class MyThread06 {
    private synchronized void run1(){
        System.out.println("进入run1方法");
        this.notify();
        System.out.println("run1执行完毕,发出通知");

    }
    public synchronized void run2() throws InterruptedException {
        System.out.println("进入run2方法");
        this.wait();
        this.notify();
        System.out.println("run2方法执行完毕，发出通知");
    }
    public synchronized void run3() throws InterruptedException {
        System.out.println("进入run3方法");
        this.wait();
        System.out.println("run3方法执行完毕，发出通知");


    }





    public static void main(String[] args) {
        MyThread06 myThread06 = new MyThread06();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myThread06.run2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myThread06.run3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread06.run1();

            }
        }).start();

    }
}
