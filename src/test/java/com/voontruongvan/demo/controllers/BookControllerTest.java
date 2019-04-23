package com.voontruongvan.demo.controllers;

import com.google.gson.Gson;
import com.voontruongvan.demo.models.Book;
import com.voontruongvan.demo.models.Category;
import com.voontruongvan.demo.repositories.BookRepository;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@EnableAutoConfiguration(exclude =  {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class BookControllerTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void init(){
        book1 = new Book();
        book1.setAuthor(null);
        book1.setCategories(null);
        book1.setName("English");
        book1.setId(0);
        book1.setPrice(57);
        book1.setYear(1990);
        book1 = bookRepository.save(book1);

        book2 = new Book();
        book2.setAuthor(null);
        book2.setId(1);
        book2.setCategories(null);
        book2.setName("Hoa Hoc");
        book2.setPrice(98);
        book2.setYear(1990);
        book2 = bookRepository.save(book2);

        book3 = new Book();
        book3.setAuthor(null);
        book3.setId(2);
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
    public void test_getAll() throws Exception{
        ResultActions resultActions = mockMvc.perform(get("/api/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$.[0].id", Matchers.equalTo(book1.getId())))
                .andExpect(jsonPath("$.[0].name", Matchers.equalTo("English")))
                .andExpect(jsonPath("$.[1].id", Matchers.equalTo(book2.getId())))
                .andExpect(jsonPath("$.[1].name", Matchers.equalTo("Hoa Hoc")))
                .andExpect(jsonPath("$[2].id", Matchers.equalTo(book3.getId())))
                .andExpect(jsonPath("$[2].name", Matchers.equalTo("Java")));
    }

    @Test
    public void test_getIdFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/books"+"/"+book1.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.equalTo(book1.getId())))
                .andExpect(jsonPath("$.name", Matchers.equalTo(book1.getName())));
    }

    @Test
    public void test_getIdNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/books"+"/"+book1.getId()+100))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_getFindFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/books/find"+"?name="+book1.getName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.[0].id", Matchers.equalTo(book1.getId())))
                .andExpect(jsonPath("$.[0].name", Matchers.equalTo(book1.getName())));
    }

    @Test
    public void test_getFindNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/books/find"+"?name="+book1.getName()+book2.getName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void test_getPrice() throws  Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/books"+"/between"+"?min=76&&max=98"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.[0].price", Matchers.lessThanOrEqualTo(98)))
                .andExpect(jsonPath("$.[0].price", Matchers.greaterThanOrEqualTo(76)))
                .andExpect(jsonPath("$.[1].price", Matchers.lessThanOrEqualTo(98)))
                .andExpect(jsonPath("$.[1].price", Matchers.greaterThanOrEqualTo(76)));
    }

    @Test
    public void test_deleteBoookFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/api/books"+"/"+book1.getId()))
                .andExpect(status().isOk());
        assertTrue(!bookRepository.findById(book1.getId()).isPresent());
    }

    @Test
    public void test_deleteBoookNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/api/books"+"/"+book1.getId()+1000))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_putBook() throws Exception {
        Gson gson = new Gson();
        Book book = new Book();
        book.setId(0);
        book.setName("Only love");
        book.setPrice(86);
        String json = gson.toJson(book);
        ResultActions resultActions = mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        List<Book> bookList = bookRepository.findAll();
        assertEquals(bookList.get(bookList.size()-1).getName(),"Only love");
    }

    @Test
    public void postBook() throws Exception {
        Gson gson = new Gson();
        Book book = new Book();
        book = book1;
        book.setName("Englis refactoring");
        String json = gson.toJson(book);
        ResultActions resultActions = mockMvc.perform(put("/api/books")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        List<Book> bookList = bookRepository.findAll(Sort.by("id"));
        assertEquals(bookList.get(0).getName(),"Englis refactoring");
    }

    @Test
    public void test_getNameOrderBy() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/books/orderBy"+"?oderType=desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$.[0].name", Matchers.equalTo("Java")))
                .andExpect(jsonPath("$.[1].name", Matchers.equalTo("Hoa Hoc")))
                .andExpect(jsonPath("$.[2].name", Matchers.equalTo("English")));
        mockMvc.perform(get("/api/books/orderBy"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$.[2].name", Matchers.equalTo("Java")))
                .andExpect(jsonPath("$.[1].name", Matchers.equalTo("Hoa Hoc")))
                .andExpect(jsonPath("$.[0].name", Matchers.equalTo("English")));
    }
}
