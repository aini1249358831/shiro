package com.example.shiro2.entity;
import javax.persistence.*;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue
    private Integer mid;
    private String mname;
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "Module{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }
}
