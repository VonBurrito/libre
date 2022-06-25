package com.libre.util;

import com.libre.dto.AuthorDTO;
import com.libre.dto.BookDTO;
import com.libre.model.Author;
import com.libre.model.Book;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/22/2022
 */
@Component
public class ModelMapperUtil {

    private ModelMapper mapper;

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public AuthorDTO mapToDto(Author author) {
        AuthorDTO authorDto = mapper.map(author, AuthorDTO.class);
        return authorDto;
    }

    public Author mapToEntity(AuthorDTO authorDto) {
        Author author = mapper.map(authorDto, Author.class);
        return author;
    }

    public List<AuthorDTO> mapToAuthorDTOList(List<Author> authors) {
        List<AuthorDTO> entityToDto = mapper.map(authors, new TypeToken<List<AuthorDTO>>() {
        }.getType());
        return entityToDto;
    }

    public BookDTO mapToDto(Book book) {
        BookDTO bookDTO = mapper.map(book, BookDTO.class);
        return bookDTO;
    }

    public Book mapToEntity(BookDTO bookDTO) {
        Book book = mapper.map(bookDTO, Book.class);
        return book;
    }

    public List<BookDTO> mapToBookDTOList(List<Book> books) {
        List<BookDTO> entityToDto = mapper.map(books, new TypeToken<List<BookDTO>>() {
        }.getType());
        return entityToDto;
    }
}
