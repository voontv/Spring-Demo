package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByPriceBetween(int min, int max);

    Iterable<Book> findByNameContaining(String pattern);

    @Query("select u from Book u where name like %:name% order by name asc")
    List<Book> findByNameContainsOrderByNameAsc(String name);

    @Query("select u from Book u where name like %:name% order by name desc")
    List<Book> findByNameContainsOrderByNameDesc(String name);

    @Query("select u from Book u where name like %:name%")
    List<Book> findAllByNameContains(String name);

    List<Book> findAll();
}