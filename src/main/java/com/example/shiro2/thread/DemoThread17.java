package com.example.shiro2.thread;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class DemoThread17 {
 private static void test1(){
     /*final ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();*/
       final Hashtable<String,Integer> concurrentHashMap = new Hashtable<>();
     for (int i = 0; i < 10; i++) {

         new Thread(new Runnable() {
             @Override
             public void run() {
                 long start = System.currentTimeMillis();
                 for (int i1 = 0; i1 < 10000000; i1++) {
                     concurrentHashMap.put("a"+i1,i1);
                 }
                 System.out.println(System.currentTimeMillis()-start);
             }
         }).start();

     }
 }
 public static void test2(){
     final TreeMap<String,Integer> sortedMap = new TreeMap<>();

     for (int i = 0; i < 10; i++) {

         new Thread(new Runnable() {
             @Override
             public void run() {
                 long start = System.currentTimeMillis();
                 for (int i1 = 0; i1 < 10000; i1++) {
                        sortedMap.put("a"+i1,i1);
                 }
                 System.out.println(System.currentTimeMillis()-start);
             }
         }).start();

     }



 }
    private static void test3(){
        ConcurrentHashMap<String,Integer> concurrent = new ConcurrentHashMap<>();
        concurrent.put("a",1);
        concurrent.put("b",2);
        concurrent.put("c",3);
        concurrent.putIfAbsent("c",5);
        concurrent.putIfAbsent("e",6);
        for (Map.Entry<String, Integer> entry : concurrent.entrySet()) {
            System.out.println(entry);

        }



    }




    public static void main(String[] args) {
     /*test1();*/
        /*test2();*/
        test3();

    }
}
