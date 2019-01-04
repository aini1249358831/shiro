package com.example.shiro2.thread;

import java.util.concurrent.CopyOnWriteArraySet;

public class DemoThread18 {
    public static void main(String[] args) {
        /*CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.addIfAbsent("e");
        for (String s : arrayList) {
            System.out.println(s);
        }*/
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.add("s");
        set.add("s");
        set.add("s");
        for (String s : set) {
            System.out.println(s);
        }

    }
}
