package com.libre.repository;

import com.libre.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hamza Amentag
 * @since 6/22/2022
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
