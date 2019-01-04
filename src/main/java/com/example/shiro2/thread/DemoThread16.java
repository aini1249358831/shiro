package com.example.shiro2.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoThread16 {

    public static void main(String[] args) {
        final List<String> list = Collections.synchronizedList(new ArrayList<>());
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10000; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    list.add("5");

                }
            });


        }
        pool.shutdown();
        while(true){
            if(pool.isTerminated()){
                if(list.size()==10000){
                    System.out.println("安全"+list.size());

                }
                else{
                    System.out.println("不安全"+list.size());
                }
                break;

            }

        }


    }
}
