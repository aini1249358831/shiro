package com.example.shiro2.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DemoThread29 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);//通过acquire()和release()来获取和释放许可证集合
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"线程尝试获得许可证");
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"线程获取许可证");
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName()+"线程释放许可证");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            };
            pool.execute(runnable);

        }
        pool.shutdown();


    }
}
