package com.example.shiro2.thread;

public class DemoTest1 {
     private static class Factory{
      private static DemoTest1 getInstance = new DemoTest1();

    }
    private DemoTest1(){
        if(Factory.getInstance!=null){
            throw new RuntimeException();
        }
    }
    public static DemoTest1 getInstance(){

        return  Factory.getInstance;
    }



}
