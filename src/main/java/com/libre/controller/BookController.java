package com.libre.controller;

import com.libre.dto.BookDTO;
import com.libre.exception.ApiRequestException;
import com.libre.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/26/2022
 */
@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> addAuthor(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.addBook(bookDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
        } catch (ApiRequestException exception) {
            throw new ApiRequestException("");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book with id " + id + " has been deleted!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateAuthor(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.updateBook(id, bookDTO), HttpStatus.OK);
    }
}
