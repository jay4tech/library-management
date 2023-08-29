package com.tcs.library.librarymanagement.entity;

import lombok.Data;

import javax.persistence.*;
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