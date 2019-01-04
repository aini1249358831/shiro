package com.example.shiro2.thread;

import java.util.Objects;

public class Demo implements Comparable {
    private Integer id;
    private String name;

    public Demo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return Objects.equals(id, demo.id) &&
                Objects.equals(name, demo.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Object o) {
        Demo demo = (Demo) o;
        if(demo.id>this.id){
            return  -1;

        }
        else if (demo.id==this.id){
            return 0;

        }
        else
        return 1;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
