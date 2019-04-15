package com.voontruongvan.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity

public class Publisher {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;
}
