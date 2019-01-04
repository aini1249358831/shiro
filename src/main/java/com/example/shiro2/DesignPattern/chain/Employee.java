package com.example.shiro2.DesignPattern.chain;

public class Employee {
        private Integer day;
        private String  reason;

    public Employee(Integer day, String reason) {
        this.day = day;
        this.reason = reason;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
