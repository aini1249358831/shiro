package com.example.shiro2.DesignPattern.iterator;

public interface MyIterator {
    void first();
    void next();
    boolean isFirst();
    boolean isLast();
    boolean hasNext();
    Object currebtObject();//获取当前游标指向的内容

}
