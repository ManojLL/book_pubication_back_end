package com.manojLL.book_publication.service;

import com.manojLL.book_publication.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    AuthorDto createAuthor(AuthorDto authorDto);
    List<AuthorDto> getAllAuthors();
    AuthorDto getAuthorById(Integer id);

    AuthorDto updateAuthor(AuthorDto authorDto);

    Integer deleteAuthor(Integer id);

}
