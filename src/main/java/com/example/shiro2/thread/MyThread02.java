package com.example.shiro2.thread;

public class MyThread02 {
    private String name="abc";
    private Integer id = 123;
    public synchronized void run1() throws InterruptedException {
        id = id+1;
        Thread.sleep(3000);
        System.out.println(name);
        System.out.println(Thread.currentThread().getName()+"run1()");

    }
    public   synchronized void run2() throws InterruptedException {
        name = "aasad";
        Thread.sleep(1000);
        System.out.println(id);
        System.out.println(Thread.currentThread().getName()+"run2()");
    }

    public static void main(String[] args) {
       MyThread02 t =   new MyThread02();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.run1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   t.run2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }



}
