package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    private Author author2;

    @Before
    public void init() {
        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Voon truong van");
        author1.setEmail("Voontv@gmail.com");
        author1.setWebsite("unitest.com");
        author1.setBooks(null);
        author1.setFavoriteQuote("Try learn");
        author1 = authorRepository.save(author1);

        author2 = new Author();
        author2.setId(2);
        author2.setName("Vo Quang Hoa");
        author2.setEmail("quanghoa@gmail.com");
        author2.setWebsite("unitest.com");
        author2.setBooks(null);
        author2 = authorRepository.save(author2);

        Author author3 = new Author();
        author3.setId(3);
        author3.setName("Vo Thi Quy");
        author3.setWebsite("unitest.com");
        author3.setBooks(null);
        author3 = authorRepository.save(author3);
    }

    @After
    public void deleteInit() {
        authorRepository.deleteAll();
    }

    @Test
    public void test_findByNameContaining() {
        assertTrue(authorRepository.findByNameContaining("Vo").size()>0);
        assertFalse(authorRepository.findByNameContaining("LY Ly").size()>0);
    }

    @Test
    public void test_findByNameContains() {
        assertTrue(authorRepository.findByNameContains("Vo").size()>0);
        assertFalse(authorRepository.findByNameContains("LYLy").size()>0);
    }

    @Test
    public void test_findByEmailContaining() {
        assertTrue(authorRepository.findByEmailContaining("Voon").size()>0);
        assertFalse(authorRepository.findByEmailContaining("LYLy").size()>0);
    }

    @Test
    public void test_findByEmailContainingByQuery() {
        assertTrue(authorRepository.findByEmailContaining("Voon").size()>0);
        assertFalse(authorRepository.findByEmailContaining("LYLy").size()>0);
    }

    @Test
    public void test_deleteByNameContains() {
        authorRepository.deleteByNameContains("Voon truong van");
        assertTrue(authorRepository.findByNameContains("Voon truong van").size()==0);
    }

    @Test
    public void test_updateEmailById() {
        authorRepository.updateEmailById(author2.getId(),"voquanghoa@gmail.com");
        assertTrue(authorRepository.findByEmailContaining("voquanghoa@gmail.com").size() > 0);
    }
}
