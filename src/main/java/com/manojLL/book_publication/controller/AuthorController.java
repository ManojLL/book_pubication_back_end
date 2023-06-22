package com.manojLL.book_publication.controller;

import com.manojLL.book_publication.dto.AuthorDto;
import com.manojLL.book_publication.service.AuthorService;
import com.manojLL.book_publication.utility.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto){
        if(authorDto.getAuthorId() != null){
            throw new BusinessRuleException("Id should be null");
        }
       return authorService.createAuthor(authorDto);
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable("id") Integer id){
        return authorService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public AuthorDto updateAuthor(@PathVariable("id") Integer id, @RequestBody AuthorDto authorDto){
        if(!id.equals(authorDto.getAuthorId())){
            throw new BusinessRuleException("Id should be equal");
        }

        return authorService.updateAuthor(authorDto);
    }


    @DeleteMapping("/{id}")
    public Integer deleteAuthor(@PathVariable("id") Integer id){
        return authorService.deleteAuthor(id);
    }


}
