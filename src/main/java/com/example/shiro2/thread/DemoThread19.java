package com.example.shiro2.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

public class DemoThread19 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("a");
        queue.add("b");
        queue.offer("c");
        String peek = queue.peek();
        System.out.println(peek);//查看不移除
        String poll = queue.poll();//查看并且移除
        System.out.println(poll);
        System.out.println(queue.size());
    }
}
