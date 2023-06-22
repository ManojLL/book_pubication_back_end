package com.manojLL.book_publication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private Integer authorId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
}
