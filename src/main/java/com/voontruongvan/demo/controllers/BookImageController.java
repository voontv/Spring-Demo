package com.voontruongvan.demo.controllers;

import com.voontruongvan.demo.models.BookImage;
import com.voontruongvan.demo.repositories.BookImageRepository;
import com.voontruongvan.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bookImages")
public class BookImageController {

    @Autowired
    private BookImageRepository bookImageRepository;
    @GetMapping
    Iterable<BookImage> get() {
        return bookImageRepository.findAll();
    }

    @PostMapping("api/setCover")
    void setCover() {

    }
}
