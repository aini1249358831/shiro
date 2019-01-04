package com.example.shiro2.DesignPattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

            List<Object> list = new ArrayList<>();
            list.add("a");
            list.add("b");
            list.add("c");
            MyCount myCount = new MyCount(list);
            MyIterator myIterator  = myCount.createIterator();
        /*while(myIterator.hasNext()){
            Object o = myIterator.currebtObject();
            System.out.println(o);
            myIterator.next();


        }*/


        }
}
