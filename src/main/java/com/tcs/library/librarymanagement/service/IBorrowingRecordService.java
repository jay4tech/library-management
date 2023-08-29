package com.tcs.library.librarymanagement.service;

import com.tcs.library.librarymanagement.entity.Book;
import org.springframework.transaction.annotation.Transactional;

public interface IBorrowingRecordService {

    @Transactional(rollbackFor = Exception.class)
    Book borrowBook(Book book, String user) throws RuntimeException;
}
