package com.libre.service;

import com.libre.dto.BookDTO;
import com.libre.model.Author;
import com.libre.model.Book;
import com.libre.repository.BookRepository;
import com.libre.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/25/2022
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private ModelMapperUtil modelMapperUtil;
    private ModelMapper modelMapper;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setModelMapperUtil(ModelMapperUtil modelMapperUtil) {
        this.modelMapperUtil = modelMapperUtil;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = modelMapperUtil.mapToEntity(bookDTO);
        return modelMapperUtil.mapToDto(bookRepository.save(book));
    }

    @Override
    public List<BookDTO> getBookList() {
        return modelMapperUtil.mapToBookDTOList(bookRepository.findAll());
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        }
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        if (bookRepository.findById(id).isPresent()) {
            bookDTO.setId(id);
            Book book = bookRepository.findById(id).get();
            modelMapper.map(bookDTO, book);
            return modelMapperUtil.mapToDto(bookRepository.save(book));
        }
        return null;
    }

    @Override
    public BookDTO getBook(Long id) {

        if (bookRepository.findById(id).isPresent()) {
            modelMapperUtil.mapToDto(bookRepository.findById(id).get());
        }
        return null;
    }
}
