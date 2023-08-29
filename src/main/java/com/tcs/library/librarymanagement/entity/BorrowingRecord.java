package com.tcs.library.librarymanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="BORROWING_RECORD")
@Data
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Book book;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private String user;
}