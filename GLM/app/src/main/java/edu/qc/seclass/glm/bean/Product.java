package edu.qc.seclass.glm.bean;

import androidx.room.Entity;

import java.io.Serializable;


@Entity
public class Product implements Serializable {
    private String id;
    private String name; //
    private String addtime; // leave it here for future, Make the code scalable
    private Boolean check = true; // show the item color black or gray
    private int num = 1; // init quantity

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void addNum() {
        this.num=this.num+1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
