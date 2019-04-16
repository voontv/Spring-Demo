package com.voontruongvan.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    private String website;

    private String favoriteQuote;

    @OneToMany
    private Set<Book> books;
}
