package com.voontruongvan.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.voontruongvan.demo.models.Category;
import com.voontruongvan.demo.repositories.CategoryRepository;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    Optional<Category> get(@PathVariable int id){

        return categoryRepository.findById(id);
    }

    @GetMapping
    Iterable<Category> get(){
        return categoryRepository.findAll();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        categoryRepository.deleteById(id);
    }

    @PostMapping()
    void post(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @PutMapping()
    void put(@RequestBody Category category) {
        categoryRepository.save(category);
    }
}