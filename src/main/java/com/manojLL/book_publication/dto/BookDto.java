package com.manojLL.book_publication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Integer bookId;
    private String ISBNNo;
    private String category;
    private String title;
    private Integer like;
    private Integer authorId;

    private AuthorDto author;

}
