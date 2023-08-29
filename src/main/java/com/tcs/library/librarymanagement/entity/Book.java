package com.tcs.library.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

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

