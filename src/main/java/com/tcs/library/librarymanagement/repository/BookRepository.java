package com.tcs.library.librarymanagement.repository;

import com.tcs.library.librarymanagement.entity.Book;
import com.tcs.library.librarymanagement.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> getByIdAndStatus(Long id, BookStatus status);
}
