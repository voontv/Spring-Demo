package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Iterable<Book> findByNameContaining(String pattern);
}