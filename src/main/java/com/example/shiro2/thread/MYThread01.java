package com.example.shiro2.thread;

public class MYThread01 {
    private String name="张三";
    private String address="昌平";



   private synchronized    void setValues(String name, String address) throws InterruptedException {
       this.name = name;
       Thread.sleep(5000);
       this.address = address;
       System.out.println(name+"---"+address);
   }
   private  void getValues(){
       System.out.println(name+"-----"+address);
   }


    public static void main(String[] args) throws InterruptedException {
       MYThread01 t2 = new MYThread01();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.setValues("李四","大兴");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
        Thread.sleep(6000);
        t2.getValues();

    }
}
