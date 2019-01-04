package com.example.shiro2.DesignPattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class MyCount {
    private List<Object> list = new ArrayList<>();

    public MyCount(List<Object> list) {
        this.list = list;
    }

    public void addObject(Object obj){

       this.list.add(obj);
    }
    public void removeObject(Object obj){
        this.list.remove(obj);
    }


    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
    public MyIterator createIterator(){

        return new CreatIterator();
    }
    private class CreatIterator implements MyIterator{
       private  int cusor;

        @Override
        public void first() {
           cusor = 0;
        }

        @Override
        public void next() {
        if(cusor<list.size()){
            cusor++;
        }

        }

        @Override
        public boolean isFirst() {
            return cusor == 0;
        }

        @Override
        public boolean isLast() {
            return cusor==(list.size()-1);
        }

        @Override
        public boolean hasNext() {
            if(cusor<list.size()){
                return true;
            }
            return false ;
        }

        @Override
        public Object currebtObject() {
            return list.get(cusor);
        }
    }

}
