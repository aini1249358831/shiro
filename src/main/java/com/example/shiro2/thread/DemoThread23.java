package com.example.shiro2.thread;

import java.util.concurrent.DelayQueue;

public class DemoThread23 {
    DelayQueue<User> delayQueue = new DelayQueue<>();
    public void login(User user){
        delayQueue.add(user);
        System.out.println("用户（"+user.getId()+")"+user.getName()+"已经登陆，预计下机时间为"+user.getEndTime());

    }
    public void loginout() throws InterruptedException {
        System.out.println(delayQueue);
        User user = delayQueue.take();
        System.out.println("用户("+user.getId()+")"+user.getName()+"到时自动退出"+System.currentTimeMillis());

    }
    public int onlineSize(){

        return delayQueue.size();
    }

    public static void main(String[] args) throws InterruptedException {
        DemoThread23 thread23 = new DemoThread23();
        thread23.login(new User(1,"甲",5000+System.currentTimeMillis()));
        thread23.login(new User(2,"乙",4000+System.currentTimeMillis()));
        thread23.login(new User(3,"丙",3000+System.currentTimeMillis()));
        while(true){
            thread23.loginout();
            if(thread23.onlineSize()==0){
                break;

            }


        }

    }
}
