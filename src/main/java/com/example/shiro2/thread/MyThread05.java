package com.example.shiro2.thread;

import java.util.ArrayList;
import java.util.List;

public class MyThread05 {
   /*private volatile boolean canGet = false;*/
   private volatile List<String> list = new ArrayList<>();
   private Object lock = new Object();
   private void put() throws InterruptedException {
       synchronized (lock){
           for (int i = 0; i < 10; i++) {
               Thread.sleep(1000);
               list.add("A");
               System.out.println("向线程"+Thread.currentThread().getName()+"中添加第"+i+"个元素");
               if (i==5) {
                   System.out.println("线程"+Thread.currentThread().getName()+"发出通知");
                   lock.notify();//发出线程通知但是不释放锁

               }

           }

       }


   }
   public void get() throws InterruptedException {
       synchronized (lock){

               System.out.println("当前线程等待获得数据"+Thread.currentThread().getName());
               lock.wait();//线程阻塞，释放锁
               for (int i = 0; i < list.size(); i++) {
                   System.out.println("从线程"+Thread.currentThread().getName()+"中取出第"+i+"个元素");
               }


       }


       }






    public static void main(String[] args) {
      final MyThread05 myThread05 = new MyThread05();
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   myThread05.get();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   myThread05.put();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();

    }
}
