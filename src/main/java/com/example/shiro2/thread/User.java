package com.example.shiro2.thread;

import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class User implements Delayed {
    private Integer id;
    private String name;
    private Long endTime;

    public User(Integer id, String name, Long endTime) {
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(endTime, user.endTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, endTime);
    }
     //计算延迟时间，当
    @Override
    public long getDelay(TimeUnit unit) {
        return this.endTime-System.currentTimeMillis();
    }
   //
    @Override
    public int compareTo(Delayed o) {
        User user = (User) o;
        if(user.endTime<this.endTime){
            return 1;

        }
        else if(user.endTime==this.endTime){
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", endTime=" + endTime +
                '}';
    }
}
