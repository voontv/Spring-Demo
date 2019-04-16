package com.voontruongvan.demo.controllers;

import com.voontruongvan.demo.models.Publisher;
import com.voontruongvan.demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/{id}")
    Optional<Publisher> get(@PathVariable  int id) {
        return publisherRepository.findById(id);
    }

    @GetMapping()
    Iterable<Publisher> get() {
        return publisherRepository.findAll();
    }

    @DeleteMapping("/{id}")
    void deleteted(@PathVariable int id) {
        publisherRepository.deleteById(id);
    }

    @PostMapping()
    void post(@RequestBody Publisher publisher) {
        publisher.setId(0);
        publisherRepository.save(publisher);
    }

    @PutMapping()
    void put(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
    }
}
