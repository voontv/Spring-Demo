package com.voontruongvan.demo.controllers;

import com.voontruongvan.demo.models.Book;
import com.voontruongvan.demo.repositories.BookRepository;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/find")
    Iterable<Book> find(@RequestParam String name){
        return bookRepository.findByNameContaining(name);
    }

    @GetMapping("/{id}")
    Optional<Book> get(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @GetMapping("/between")
    List<Book> get(@RequestParam int max, @RequestParam int min) {
        return bookRepository.findBookByPriceBetween(max, min);
    }

    @GetMapping("/betweenQuery")
    List<Book> getBetweenWithQuery(@RequestParam int max, @RequestParam int min) {
        return bookRepository.findBookByPriceBetweenWithQuery(max, min);
    }

    @GetMapping
    List<Book> get(@RequestParam (value = "q", defaultValue = "") String q, @RequestParam(value =  "oderType", defaultValue = "asc") String oderType){
        if(oderType.equalsIgnoreCase("desc")) {
            return bookRepository.findAllByOrderByNameAuthorDesc(q);
        } else {
            return bookRepository.findAllByOrderByNameAuthorAsc(q);
        }
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        bookRepository.deleteById(id);
    }

    @PostMapping()
    void post(@RequestBody Book book){
        book.setId(0);
        bookRepository.save(book);
    }

    @PutMapping()
    void put(@RequestBody Book book){
        bookRepository.save(book);
    }
}
