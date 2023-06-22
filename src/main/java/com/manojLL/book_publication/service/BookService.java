package com.manojLL.book_publication.service;

import com.manojLL.book_publication.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto createNewBook(BookDto bookDto);

    BookDto searchBookByISBNno(String ISBN);

    BookDto addLike(Integer id);

    Integer deleteBook(Integer id);

    List<BookDto> getAllBooks();

    BookDto getBookById(Integer id);
}
