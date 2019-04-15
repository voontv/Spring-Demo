package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findBookByPriceBetween(int min, int max);

    @Query("select u from Book u where price <= :max AND price >= :min")
    List<Book> findBookByPriceBetweenWithQuery(int max, int min);

    @Query("select u from Book u where name like %:pattern%")
    Iterable<Book> findByNameContaining(String pattern);

    @Query("Select u from Book u where name like %:name% order by name asc")
    List<Book> findAllByOrderByNameAuthorAsc(String name);

    @Query("Select u from Book u where name like %:name% order by name desc")
    List<Book> findAllByOrderByNameAuthorDesc(String name);

}