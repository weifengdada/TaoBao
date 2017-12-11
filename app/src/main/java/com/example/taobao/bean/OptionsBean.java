package com.example.taobao.bean;

/**
 * Created by acer on 2017/12/9.
 */

public class OptionsBean {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OptionsBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "OptionsBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
