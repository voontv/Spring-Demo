package com.voontruongvan.demo.controllers;


import org.springframework.web.bind.annotation.*;
import com.voontruongvan.demo.models.Book;
@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping("/{id}")
    Book get(@PathVariable int id){
        Book book = new Book();
        book.setId(id);
        book.setName("Harry porter");
        book.setYear(2001);

        return book;
    }

    @GetMapping
    Book[] get(){
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Harry porter");
        book1.setYear(2001);

        Book book2 = new Book();
        book2.setId(2);
        book2.setName("Life of Pie");
        book2.setYear(202);

        Book book3 = new Book();
        book3.setId(3);
        book3.setName("Training java");
        book3.setYear(2019);

        Book book4 = new Book();
        book4.setId(4);
        book4.setName("Training Spring");
        book4.setYear(2019);


        return new Book[]{book1, book2, book3, book4};
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        System.out.println("Delete book id " + id);
    }

    @PostMapping()
    void post(@RequestBody Book book){
        System.out.println("Create book " + book);
    }


    @PutMapping()
    void put(@RequestBody Book book){
        System.out.println("Update book " + book);
    }
}
