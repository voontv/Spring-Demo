package com.voontruongvan.demo;

import com.voontruongvan.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				/*
				Book book1 = new Book();
				book1.setName("Hidden sea");
				book1.setYear(1990);

				Book book2 = new Book();
				book2.setName("English on hand");
				book2.setYear(2000);

				Category category1 = new Category();
				category1.setLabel("English");
				category1 = categoryRepository.save(category1);

				Category category2 = new Category();
				category2.setLabel("Novel");
				category2 = categoryRepository.save(category2);

				book1.setCategories(new HashSet<>());
				book1.getCategories().add(category1);
				book1.getCategories().add(category2);

				book2.setCategories(new HashSet<>());
				book2.getCategories().add(category1);

				book1 = bookRepository.save(book1);
				book2 = bookRepository.save(book2);
				System.out.println("Hello World");
				Author author = new Author();
				author.setId(1);
				author.setName("Hoa");
				author.setEmail("hoa@gmail.com");
				author.setWebsite("stuck.com");
				author.setFavoriteQuote("Try learn demo");
				author = authorRepository.save(author);

				Book book = new Book();
				book.setAuthor(author);
				book.setName("Harry");
				book.setYear(1990);

				int savedId = bookRepository.save(book).getId();

				Book savedBook = bookRepository.findById(savedId).get();

				System.out.println(savedBook);*/
			}
		};
	}
}
