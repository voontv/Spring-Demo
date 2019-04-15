package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    List<Author> findByNameContaining(String name);

    @Query("select u from Author u where email like :email")
    List<Author> findByEmailContaining(String email);

    @Transactional
    @Modifying
    @Query("delete Author  where id = :id and name = :name")
    void deleteAllByIdAndAndName(int id, String name);

    @Transactional
    @Modifying
    @Query(value = "update Author  set email = :newEmail where id = :id")
    void updateEmailById(int id, String newEmail);

    @Transactional
    @Modifying
    @Query("update Author  set price = id*3.9")
    void updateAllPriceForAuthor();
}
