package com.voontruongvan.demo.controllers;

import com.voontruongvan.demo.models.Author;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voon/author")
public class AuthorController {

    @GetMapping("/{id}")
    Author get(@PathVariable int id) {
        Author author = new Author();
        author.setId(id);
        author.setName("Vo Quang Hoa");
        author.setYear(1989);
        return author;
    }

    @GetMapping()
    Author[] get(){
        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Vo Quang Hoa");
        author1.setYear(1989);

        Author author2 = new Author();
        author2.setId(2);
        author2.setName("Truong Van Voon");
        author2.setYear(1988);

        return new Author[] {author1, author2};
    }

    @PostMapping
    void post(@RequestBody Author author) {
        System.out.println("Created author"+author);
    }

    @PutMapping
    void put(@RequestBody Author author) {
        System.out.println("Update author"+author);
    }

    @DeleteMapping
    void delete(@PathVariable int id) {
        System.out.println("Deleted author id "+id);
    }

}
