package com.manojLL.book_publication.dao;

import com.manojLL.book_publication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByISBNNo(String isbn);
}
