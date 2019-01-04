package com.example.shiro2.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DemoThread20 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.add(1);
        /*arrayBlockingQueue.add(null);*///不能添加null值
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);
        arrayBlockingQueue.offer(4,2,TimeUnit.SECONDS);//队列满了可以设置阻塞时间
        /*arrayBlockingQueue.add(4);//队列满了直接抛出异常*/
        try {
            arrayBlockingQueue.put(4);//队列满了则进行等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrayBlockingQueue);
        System.out.println(arrayBlockingQueue.peek());//只进行查看
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));//队列为空则输出null值
        /*System.out.println(arrayBlockingQueue.take());*///若队列为空则进行阻塞


    }
}
