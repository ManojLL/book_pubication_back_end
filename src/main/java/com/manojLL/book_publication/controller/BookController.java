package com.manojLL.book_publication.controller;

import com.manojLL.book_publication.dto.BookDto;
import com.manojLL.book_publication.service.BookService;
import com.manojLL.book_publication.utility.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        if (bookDto.getBookId() != null) {
            throw new BusinessRuleException("Id should be null");
        }
        return bookService.createNewBook(bookDto);
    }

    @PutMapping("/like/{id}")
    public BookDto addLike(@PathVariable("id") Integer id){
        return bookService.addLike(id);
    }

    @GetMapping
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/isbn")
    public BookDto getBookByISBN(@RequestParam("isbn") String isbn){
        return bookService.searchBookByISBNno(isbn);
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable("id") Integer id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public Integer deleteBook(@PathVariable("id") Integer id){
        return bookService.deleteBook(id);
    }
}
