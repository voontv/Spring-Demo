package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findBookByPriceBetween(int min, int max);

    Iterable<Book> findByNameContaining(String pattern);

    List<Book> findAllByNameOrderByNameAsc(String name);

    List<Book> findAllByNameOrderByNameDesc(String name);

}