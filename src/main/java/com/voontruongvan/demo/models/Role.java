package com.voontruongvan.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;


    @Column(nullable = false)
    @NonNull
    private String name;


    @Column
    @NonNull
    private String description;
}
