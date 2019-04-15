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

    /*@GetMapping
    Iterable<Book> get(){
        return bookRepository.findAll();
    }*/

    @GetMapping()
    String get(@RequestParam(value = "q", defaultValue = "") String q,
                   @RequestParam( value = "order", defaultValue = "") String order,
                   @RequestParam(value = "oderType", defaultValue = "ASC", required = false) String oderType){
        return "q "+q+" order "+order+" oderType "+oderType;
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
