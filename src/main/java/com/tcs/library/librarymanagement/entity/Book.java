package com.tcs.library.librarymanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name ="BOOK")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String ISBN;
    @ManyToOne
    private Author author;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
}

