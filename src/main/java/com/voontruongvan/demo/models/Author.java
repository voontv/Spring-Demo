package com.voontruongvan.demo.models;

public class Author {

    private int id;

    private String name;

    private int year;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Author id %d %s and year %d",id,name,year);
    }
}
