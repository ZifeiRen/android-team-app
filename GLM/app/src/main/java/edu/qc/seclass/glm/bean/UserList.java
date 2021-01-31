package edu.qc.seclass.glm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserList implements Serializable {

    private ArrayList<Item> list; // items in the list
    private String name; // list name

    public List<Item> getList() {
        return list;
    }

    public void setList(ArrayList<Item> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
