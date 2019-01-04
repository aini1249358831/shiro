package com.example.shiro2.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DemoTest {
    public static void main(String[] args) {
        final ReadWriteLock writeLock = new ReadWriteLock();
        /*for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    writeLock.set(new Random().nextInt(1000));



                }
            }).start();
        }*/

        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    writeLock.get();

                }
            }).start();

        }






    }
}
class ReadWriteLock{
    private int number = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(){
        try{
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"-------取出的值为"+number);

        } finally {
            lock.readLock().unlock();
        }


    }
    public void set(int number){
        try{
            lock.writeLock().lock();
            Thread.sleep(1000);
            this.number = number;
            System.out.println(Thread.currentThread().getName()+"-------设置的值为"+this.number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }





    }









}
