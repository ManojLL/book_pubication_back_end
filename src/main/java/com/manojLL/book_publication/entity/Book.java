package com.manojLL.book_publication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookId")
    private Integer bookId;
    @Column(name = "ISBNNo")
    private String ISBNNo;
    @Column(name = "category")
    private String category;
    @Column(name = "title" )
    private String title;
    @Column(name = "book_like" )
    private Integer like;

    @ManyToOne
    @JoinColumn(name = "author_author_id")
    private Author author;

}
