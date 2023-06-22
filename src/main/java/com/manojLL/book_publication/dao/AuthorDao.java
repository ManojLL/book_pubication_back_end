package com.manojLL.book_publication.dao;

import com.manojLL.book_publication.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
    Optional<Author> findAuthorByEmail(String email);

}
