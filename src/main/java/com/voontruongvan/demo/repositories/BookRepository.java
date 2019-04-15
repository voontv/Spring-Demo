package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findBookByPriceBetween(int min, int max);

    @Query("select u from Book u where price <= :max AND price >= :min")
    List<Book> findBookByPriceBetweenWithQuery(int min, int max);

    @Query("select u from Book u where name like %:pattern%")
    Iterable<Book> findByNameContaining(String pattern);

    //List<Book> findAllByOrderByNameAuthorAsc();

}