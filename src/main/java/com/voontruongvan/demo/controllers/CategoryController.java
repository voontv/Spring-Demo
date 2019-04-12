package com.voontruongvan.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.voontruongvan.demo.models.Category;

@RestController
@RequestMapping("/api/categorys")
public class CategoryController {

    @GetMapping("/{id}")
    Category get(@PathVariable int id){
        Category category = new Category();
        category.setId(id);
        category.setType("Love");
        category.setAgeLimit("Age lowest 18");
        return category;
    }

    @GetMapping
    Category[] get(){
        Category category1 = new Category();
        category1.setId(1);
        category1.setType("Love");
        category1.setAgeLimit("Age lowest 18");

        Category category2 = new Category();
        category2.setId(2);
        category2.setType("Relax");
        category2.setAgeLimit("Age lowest 5");

        return new Category[] {category1,category2};
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        System.out.println("Deleted category have id" +id);
    }

    @PostMapping()
    void post(@RequestBody Category category) {
        System.out.println("Create category " + category);
    }

    @PutMapping()
    void put(@RequestBody Category category) {
        System.out.println("Update category " + category);
    }
}