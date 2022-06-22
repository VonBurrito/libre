package com.libre.service;

import com.libre.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    public AuthorDTO addAuthor(AuthorDTO authorDTO);

    public List<AuthorDTO> getAuthorList();

    public void deleteAuthor(Long id);

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO);
}
