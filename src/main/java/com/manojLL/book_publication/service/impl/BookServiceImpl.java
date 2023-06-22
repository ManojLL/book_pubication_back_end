package com.manojLL.book_publication.service.impl;

import com.manojLL.book_publication.dao.AuthorDao;
import com.manojLL.book_publication.dao.BookDao;
import com.manojLL.book_publication.dto.BookDto;
import com.manojLL.book_publication.entity.Author;
import com.manojLL.book_publication.entity.Book;
import com.manojLL.book_publication.service.AuthorService;
import com.manojLL.book_publication.service.BookService;
import com.manojLL.book_publication.utility.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    AuthorService authorService;

    @Override
    public BookDto createNewBook(BookDto bookDto) {
        Optional<Author> author = authorDao.findById(bookDto.getAuthorId());
        if(!author.isPresent()){
            throw new BusinessRuleException("author not found for id : "+ bookDto.getAuthorId());
        }

        Book book = new Book();
        book.setLike(0);
        book.setAuthor(author.get());
        book.setTitle(bookDto.getTitle());
        book.setCategory(bookDto.getCategory());
        book.setISBNNo(bookDto.getISBNNo());
        book = bookDao.save(book);
        return getBookDto(book);
    }

    @Override
    public BookDto searchBookByISBNno(String ISBN) {
        Optional<Book> book = bookDao.findBookByISBNNo(ISBN);
        if (!book.isPresent()) {
            throw new BusinessRuleException("book not found for ISBN : " + ISBN);
        }

        return getBookDto(book.get());
    }

    @Override
    public BookDto addLike(Integer id) {
        Optional<Book> book = bookDao.findById(id);
        if (!book.isPresent()) {
            throw new BusinessRuleException("book not found for id : " + id);
        }
        Book book1 = book.get();
        book1.setLike(book1.getLike() + 1);
        book1 = bookDao.save(book1);
        return getBookDto(book1);
    }

    @Override
    public Integer deleteBook(Integer id) {
        Optional<Book> book = bookDao.findById(id);
        if (!book.isPresent()) {
            throw new BusinessRuleException("book not found for id : " + id);
        }
        bookDao.delete(book.get());
        return id;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookDao.findAll();
        return books.stream().map(this::getBookDto).collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Integer id) {
        Optional<Book> book = bookDao.findById(id);
        if (!book.isPresent()) {
            throw new BusinessRuleException("book not found for id : " + id);
        }
        return getBookDto(book.get());
    }

    private BookDto getBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setBookId(book.getBookId());
        bookDto.setISBNNo(book.getISBNNo());
        bookDto.setAuthor(authorService.getAuthorById(book.getAuthor().getAuthorId()));
        bookDto.setCategory(book.getCategory());
        bookDto.setTitle(book.getTitle());
        bookDto.setLike(book.getLike());
        return bookDto;
    }
}
