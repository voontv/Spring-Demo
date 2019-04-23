package com.voontruongvan.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class BookImage {
    @Id
    private int id;

    private String name;
    private String cover;
    private String[] thumb;
}
