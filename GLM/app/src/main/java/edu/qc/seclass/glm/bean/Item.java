package edu.qc.seclass.glm.bean;

import androidx.room.Entity;

import java.io.Serializable;


@Entity
public class Item implements Serializable {

    private String item_id;// item id
    private String item_name;// item name
    private String addtime; // leave it here for future, Make the code scalable
    private Boolean check = true; // show the item color black or gray
    private int item_quantity = 1; // init quantity
    private Integer id; //product id
    private String name; // product name
    public void addNum() {
        this.item_quantity=this.item_quantity+1;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }



    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }
}
