package com.voontruongvan.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> categories;

    private int year;
    private int price;
}
