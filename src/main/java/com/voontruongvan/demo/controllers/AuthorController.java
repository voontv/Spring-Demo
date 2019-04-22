package com.voontruongvan.demo.controllers;

import com.voontruongvan.demo.models.Author;
import com.voontruongvan.demo.repositories.AuthorRepository;
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

    @GetMapping("/allQuery")
    List<Author> get(@RequestParam String name) {
        return authorRepository.findByNameContains(name);
    }
    @GetMapping()
    Iterable<Author> get(){
        return authorRepository.findAll();
    }

    @GetMapping("/emailQuery")
    List<Author> getMailByQuery(@RequestParam String email) {
        return authorRepository.findByEmailContainingByQuery(email);
    }

    @GetMapping("/email")
    List<Author> findByEmail(@RequestParam String email) {
        return authorRepository.findByEmailContaining(email);
    }

    @GetMapping("/findName")
    List<Author> findByName(@RequestParam String name) {
        return authorRepository.findByNameContaining(name);
    }

    @PostMapping
    void post(@RequestBody Author author) {
        author.setName("Refactoring");
        authorRepository.save(author);
    }

    @PutMapping
    void put(@RequestBody Author author) {
        authorRepository.save(author);
    }

    @DeleteMapping
    void delete(@PathVariable int id) {
        authorRepository.deleteById(id);
    }

    @PutMapping("/updateEmail")
    void updateEmailById(@RequestParam int id, @RequestParam String email) {
        authorRepository.updateEmailById(id, email);
    }
}
