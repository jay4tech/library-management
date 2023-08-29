package com.tcs.library.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name="AUTHOR")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}