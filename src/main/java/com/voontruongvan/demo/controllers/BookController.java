package com.voontruongvan.demo.controllers;

import com.voontruongvan.demo.NotFoundException;
import com.voontruongvan.demo.models.Book;
import com.voontruongvan.demo.repositories.AuthorRepository;
import com.voontruongvan.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    private  AuthorRepository authorRepository;
    @GetMapping("/find")
    Iterable<Book> find(@RequestParam String name){
        return bookRepository.findByNameContaining(name);
    }

    @GetMapping("/{id}")
    Book get(@PathVariable int id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return bookRepository.findById(id).get();
        }
        throw new NotFoundException(String.format("Book id %d not found",id));
    }

    @GetMapping()
    Iterable<Book> get() {
        return bookRepository.findAll(Sort.by("id"));
    }

    @GetMapping("/between")
    List<Book> get(@RequestParam int min, @RequestParam int max) {
        return bookRepository.findBookByPriceBetween(min, max);
    }

    @GetMapping("/orderBy")
    List<Book> get(@RequestParam(value =  "oderType", defaultValue = "asc") String oderType){
        if(!oderType.equalsIgnoreCase("desc")) {
            return bookRepository.findByNameContainsOrderByNameAsc("");
        } else {
            return bookRepository.findByNameContainsOrderByNameDesc("");
        }
    }

    //@Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        if(!bookRepository.existsById(id)) {
            throw new NotFoundException(String.format("Book id %d not found",id));
        }
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
