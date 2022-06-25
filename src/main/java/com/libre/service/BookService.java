package com.libre.service;

import com.libre.dto.BookDTO;

import java.util.List;

public interface BookService {

    public BookDTO addBook(BookDTO bookDTO);

    public List<BookDTO> getBookList();

    public void deleteBook(Long id);

    public BookDTO updateBook(Long id, BookDTO bookDTO);

    public BookDTO getBook(Long id);
}
