package com.manojLL.book_publication.service.impl;

import com.manojLL.book_publication.dao.AuthorDao;
import com.manojLL.book_publication.dto.AuthorDto;
import com.manojLL.book_publication.entity.Author;
import com.manojLL.book_publication.service.AuthorService;
import com.manojLL.book_publication.utility.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Optional<Author> existAuthor = authorDao.findAuthorByEmail(authorDto.getEmail());
        if(existAuthor.isPresent()){
            throw new BusinessRuleException("email exist");
        }
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setContactNo(authorDto.getContactNo());
        author.setEmail(authorDto.getEmail());
        author = authorDao.save(author);

        authorDto.setAuthorId(author.getAuthorId());
        return authorDto;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
       List<Author> authors = authorDao.findAll();
       return authors.stream().map(this::getDto).collect(Collectors.toList());
    }

    private AuthorDto getDto(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setEmail(author.getEmail());
        authorDto.setContactNo(author.getContactNo());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setAuthorId(author.getAuthorId());
        return authorDto;
    }
    @Override
    public AuthorDto getAuthorById(Integer id) {
        Optional<Author> author = authorDao.findById(id);
        if(!author.isPresent()){
            throw new BusinessRuleException("author not found for id : "+ id);
        }
        return getDto(author.get());
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Optional<Author> author = authorDao.findById(authorDto.getAuthorId());
        if(!author.isPresent()){
            throw new BusinessRuleException("author not found for id : "+ authorDto.getAuthorId());
        }
        Author author1 = new Author();
        author1.setFirstName(authorDto.getFirstName());
        author1.setLastName(authorDto.getLastName());
        author1.setContactNo(authorDto.getContactNo());
        author1.setEmail(authorDto.getEmail());
        author1 = authorDao.save(author1);

        return getDto(author1);
    }

    @Override
    public Integer deleteAuthor(Integer id) {
        return null;
    }
}
