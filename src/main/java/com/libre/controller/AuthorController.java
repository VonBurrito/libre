package com.libre.controller;

import com.libre.dto.AuthorDTO;
import com.libre.exception.ApiRequestException;
import com.libre.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/22/2022
 */
@RestController
@RequestMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    private Logger logger = LoggerFactory.getLogger(AuthorController.class);
    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO) {
        try {
            return new ResponseEntity<>(authorService.addAuthor(authorDTO), HttpStatus.OK);
        } catch (ApiRequestException e) {
            logger.error(e.getMessage());
            throw new ApiRequestException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {

        try {
            return new ResponseEntity<>(authorService.getAuthorList(), HttpStatus.OK);
        } catch (ApiRequestException e) {
            logger.error(e.getMessage());
            throw new ApiRequestException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
        } catch (ApiRequestException e) {
            logger.error(e.getMessage());
            throw new ApiRequestException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {

        try {
            authorService.deleteAuthor(id);
            return new ResponseEntity<>("Author with id " + id + " has been deleted!", HttpStatus.OK);
        } catch (ApiRequestException e) {
            logger.error(e.getMessage());
            throw new ApiRequestException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        try {
            return new ResponseEntity<>(authorService.updateAuthor(id, authorDTO), HttpStatus.OK);
        } catch (ApiRequestException e) {
            logger.error(e.getMessage());
            throw new ApiRequestException(e.getMessage());
        }
    }
}
