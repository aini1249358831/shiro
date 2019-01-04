package com.example.shiro2.thread;

import java.util.Random;
import java.util.concurrent.*;

public class DemoThread27    {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

            executorService.execute(new Runner("张三",barrier));
            executorService.execute(new Runner("李四",barrier));
            executorService.execute(new Runner("王五",barrier));

        executorService.shutdown();



    }
}
class Runner implements Runnable{
    private String name;
    private CyclicBarrier cyclicBarrier;
    public Runner(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000*(new Random().nextInt(8)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"选手准备好了");
        try {
            cyclicBarrier.await(2,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("屏障异常");
        } catch (TimeoutException e) {
            System.out.println(name+"号选手等待超时");
    }
        System.out.println(name+"开始跑了");

    }
}
