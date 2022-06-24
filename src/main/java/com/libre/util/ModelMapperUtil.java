package com.libre.util;

import com.libre.dto.AuthorDTO;
import com.libre.model.Author;
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

    public List<AuthorDTO> mapToDto(List<Author> authors) {
        List<AuthorDTO> entityToDto = mapper.map(authors, new TypeToken<List<AuthorDTO>>() {
        }.getType());
        return entityToDto;
    }
}
