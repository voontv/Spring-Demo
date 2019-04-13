package com.voontruongvan.demo.controllers;

import com.voontruongvan.demo.models.Author;
import com.voontruongvan.demo.repositories.AuthorRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private  AuthorRepository authorRepository;

    @GetMapping("/{id}")
    Optional<Author> get(@PathVariable int id) {
        return authorRepository.findById(id);
    }

    @GetMapping()
    Iterable<Author> get(){
        return authorRepository.findAll();
    }

    @PostMapping
    void post(@RequestBody Author author) {
        System.out.println("Created author"+author);
        author.setName("Refactoring");
        authorRepository.save(author);
    }

    @PutMapping
    void put(@RequestBody Author author) {
        System.out.println("Update author"+author);
        authorRepository.save(author);
    }

    @DeleteMapping
    void delete(@PathVariable int id) {
        System.out.println("Deleted author id "+id);
        authorRepository.deleteById(id);
    }

}
