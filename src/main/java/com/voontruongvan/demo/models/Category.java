package com.voontruongvan.demo.models;

public class Category {

    private int id;

    private String type;

    private String ageLimit;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgeLimit() {
        return this.ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public String toString() {
        return String.format("Category id %d %s and age request %s",id,type,ageLimit);
    }
}
