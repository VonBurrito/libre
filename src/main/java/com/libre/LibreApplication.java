package com.libre;

import com.libre.model.Author;
import com.libre.model.Book;
import com.libre.repository.AuthorRepository;
import com.libre.repository.BookRepository;
import com.libre.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LibreApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book();
        Author author = new Author();
        List<Author> authors = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        book.setAuthors(authors);
        book.setTitle("b1");
        author.setFirstName("firns");

        books.add(book);
        authors.add(author);

        bookRepository.save(book);
        author.setBooks(books);
        authorRepository.save(author);

    }
}
