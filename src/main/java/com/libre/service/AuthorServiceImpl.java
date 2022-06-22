package com.libre.service;

import com.libre.dto.AuthorDTO;
import com.libre.model.Author;
import com.libre.repository.AuthorRepository;
import com.libre.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/22/2022
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private ModelMapperUtil modelMapperUtil;
    private ModelMapper modelMapper;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
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
    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        Author author = modelMapperUtil.mapToEntity(authorDTO);
        return modelMapperUtil.mapToDto(authorRepository.save(author));
    }

    @Override
    public List<AuthorDTO> getAuthorList() {
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        if (authorRepository.findById(id).isPresent()) {
            authorDTO.setId(id);
            Author author = authorRepository.findById(id).get();
            modelMapper.map(authorDTO, author);
            return modelMapperUtil.mapToDto(authorRepository.save(author));
        }
        return null;
    }
}
