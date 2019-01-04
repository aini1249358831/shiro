package com.example.shiro2.thread;

public class Product {
    private Integer id;
    private String name;
    private boolean flag;

    private Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    synchronized void put(Integer id, String name) throws InterruptedException {
        if(flag){
            super.wait();
        }
        this.setId(id);
        this.setName(name);
        flag = true; //已经生产出来了，等待消费
        System.out.println("已经生产出产品了，等待消费");
        super.notify();
    }
    synchronized void remove() throws InterruptedException {
        if(!flag){
            super.wait();//没有产品等待
        }
        System.out.println("消费了产品"+this.getId()+"---"+this.getName());
        flag = false;
        super.notify();
    }
}
class Producter implements Runnable{
  private Product product = null;

    Producter(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
           if(i%2==0){
               try {
                   product.put(1,"香蕉");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
           else{
               try {
                   product.put(2,"例子");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

        }


    }
}
class Customer implements Runnable{
    private Product product = null;

    private Customer(Product product) {
        this.product = product;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                product.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Product product = new Product();
        Producter producter = new Producter(product);
        Customer customer =new Customer(product);
        new Thread(customer).start();
        new Thread(producter).start();
    }
}
