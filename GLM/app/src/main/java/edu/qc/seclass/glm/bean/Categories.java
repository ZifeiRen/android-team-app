package edu.qc.seclass.glm.bean;

import java.io.Serializable;

public class Categories implements Serializable {
    private Integer categories_id; //categories id
    private  String categories_name; // categories name
    private Integer id; //product id which in categories
    private String name; // product name which in categories
    private String addtime; // leave it here for future, Make the code scalable

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(Integer categories_id) {
        this.categories_id = categories_id;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }
}
