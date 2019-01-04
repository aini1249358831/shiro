package com.example.shiro2.thread;

public class MyThread04 {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private void execute1() throws InterruptedException {

        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+"lock1");
            Thread.sleep(2000);
            synchronized (lock2){

                System.out.println(Thread.currentThread().getName()+"lock2");

            }


        }

    }
    private void execute2() throws InterruptedException {
        synchronized (lock2){
            System.out.println(Thread.currentThread().getName()+"lock2");
            Thread.sleep(2000);
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+"lock1");
            }

        }

    }
    public static void main(String[] args) {
       final MyThread04 myThread04 = new MyThread04();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myThread04.execute1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myThread04.execute2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }


}
