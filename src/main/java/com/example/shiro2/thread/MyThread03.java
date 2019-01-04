package com.example.shiro2.thread;

public class MyThread03 {
    int i = 0 ;

    public synchronized void set(){
        while(true){
            System.out.println(Thread.currentThread().getName()+"-----"+i);
            i++;
            /*if(i==10){
                throw new RuntimeException("unchecked");

            }*/
            int i = 10/0;
        }

    }
        public synchronized void get(){

        System.out.println(Thread.currentThread().getName()+"i的值为"+i);
    }



    public static void main(String[] args) throws InterruptedException {
        MyThread03 myThread03 = new MyThread03();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
             myThread03.set();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread03.get();
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();


    }


}
