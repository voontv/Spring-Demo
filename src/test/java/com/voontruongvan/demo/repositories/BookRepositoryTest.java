package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Book;
import com.voontruongvan.demo.models.Category;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void init(){

        Book book1 = new Book();
        book1.setAuthor(null);
        book1.setCategories(null);
        book1.setName("Enlgish");
        book1.setPrice(57);
        book1.setYear(1990);
        book1 = bookRepository.save(book1);

        Book book2 = new Book();
        book2.setAuthor(null);
        book2.setCategories(null);
        book2.setName("Hoa Hoc");
        book2.setPrice(98);
        book2.setYear(1990);
        book2 = bookRepository.save(book2);

        Book book3 = new Book();
        book3.setAuthor(null);
        book3.setCategories(null);
        book3.setName("Java");
        book3.setPrice(88);
        book3.setYear(1990);
        book3 = bookRepository.save(book3);
    }

    @After
    public void destroy(){
        bookRepository.deleteAll();
    }

    @Test
    public void test_findBookByPriceBetween() {
        List<Book> bookList = bookRepository.findBookByPriceBetween(57,98);

        for (Book book : bookList) {
            boolean test = (book.getPrice() >= 57 && book.getPrice() <= 98);
            Assert.assertTrue(test);
        }
    }

    @Test
    public void test_findAll() {
        List<Book> bookList = bookRepository.findAll(Sort.by("id"));

        Assert.assertEquals(bookList.get(0).getName(),"Enlgish");
        Assert.assertEquals(bookList.get(1).getName(),"Hoa Hoc");
        Assert.assertEquals(bookList.get(2).getName(),"Java");
        Assert.assertEquals(bookList.size(),3);
    }

    @Test
    public void test_findByNameContaining() {
        List<Book> bookListNull = (List<Book>) bookRepository.findByNameContaining("Lich su");
        List<Book> bookListNotNull = (List<Book>) bookRepository.findByNameContaining("Enlgish");

        Assert.assertTrue(!bookListNotNull.isEmpty());
        Assert.assertTrue(bookListNull.isEmpty());
    }

    @Test
    public void test_findAllByNameContains() {
        List<Book> bookList = bookRepository.findAllByNameContains( "Enlgish");

        Assert.assertEquals(bookList.get(0).getName(), "Enlgish");
    }

    @Test
    public void test_findByNameContainsOrderByNameAsc() {
        List<Book> bookList = bookRepository.findByNameContainsOrderByNameAsc("");
        Assert.assertEquals(bookList.get(0).getName(),"Enlgish");
        Assert.assertEquals(bookList.get(2).getName(),"Java");
        Assert.assertEquals(bookList.get(1).getName(),"Hoa Hoc");
    }

    @Test
    public void test_findByNameContainsOrderByNameDesc() {
        List<Book> bookList = bookRepository.findByNameContainsOrderByNameDesc("");
        Assert.assertEquals(bookList.get(0).getName(),"Java");
        Assert.assertEquals(bookList.get(1).getName(),"Hoa Hoc");
        Assert.assertEquals(bookList.get(2).getName(),"Enlgish");
    }
}
