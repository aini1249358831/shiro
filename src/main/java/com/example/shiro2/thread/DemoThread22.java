package com.example.shiro2.thread;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DemoThread22 {
    public static void main(String[] args) throws InterruptedException {
        final PriorityBlockingQueue<Demo> priorityQueue = new PriorityBlockingQueue<>(2);
        priorityQueue.add(new Demo(4,"张三"));
        priorityQueue.offer(new Demo(3,"李四"));
        priorityQueue.add(new Demo(2,"王五"));
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll(2,TimeUnit.SECONDS));
    }
}
