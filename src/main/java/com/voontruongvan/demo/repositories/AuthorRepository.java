package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    List<Author> findByNameContaining(String name);
    @Query("select u from Author u where email = :emailAddress")
    List<Author> findByEmailAddress(String emailAddress);
}
