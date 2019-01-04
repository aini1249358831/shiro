package com.example.shiro2.thread.future2;

import java.util.concurrent.*;

public class JdkFurture implements Callable<String> {
    String param ;

    public JdkFurture(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        param = "abc";
        return param;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String jquery = "abcd";
        ExecutorService pool = Executors.newFixedThreadPool(2);
        FutureTask<String> futureTask1 = new FutureTask<>(new JdkFurture(jquery));
        FutureTask<String> futureTask2 = new FutureTask<>(new JdkFurture(jquery));
        Future<String> submit = (Future<String>) pool.submit(futureTask1);//相当于直接返回的futureData
        System.out.println(submit.get());
        pool.submit(futureTask2);
        pool.shutdown();
        Thread.sleep(3000);
        String s = futureTask1.get();
        /*String s1 = futureTask2.get();*/
        System.out.println(s);
        Thread.sleep(2000);
        /*System.out.println(s1);*/


    }
}
