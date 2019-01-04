package com.example.shiro2.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoThread26 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1); //计数器初始值 1
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        for(int i = 0;i<3;i++){
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()
                                +"正准备接受命令");
                        cdOrder.await();
                        System.out.println("线程"+Thread.currentThread().getName()
                                +"已接受命令");
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()
                                +"回应命令处理结果");
                        cdAnswer.countDown();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            };
            executorService.execute(runnable);
        }
        try {
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("线程"+Thread.currentThread().getName()
                    +"即将发布命令");
            cdOrder.countDown();  //计数器数值减 1
            System.out.println("线程"+Thread.currentThread().getName()
                    +"已发送命令，正在等待结果");
            cdAnswer.await();
            System.out.println("线程"+Thread.currentThread().getName()
                    +"已收到所有响应结果");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executorService.shutdown();
    }
    }

