package com.libre.controller;

import com.libre.dto.AuthorDTO;
import com.libre.exception.ApiRequestException;
import com.libre.service.AuthorService;
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

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorService.addAuthor(authorDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAuthorList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
        } catch (ApiRequestException exception) {
            throw new ApiRequestException("");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author with id " + id + " has been deleted!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorService.updateAuthor(id, authorDTO), HttpStatus.OK);
    }
}
