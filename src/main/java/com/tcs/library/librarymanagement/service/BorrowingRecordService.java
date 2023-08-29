package com.tcs.library.librarymanagement.service;

import com.tcs.library.librarymanagement.entity.Book;
import com.tcs.library.librarymanagement.entity.BookStatus;
import com.tcs.library.librarymanagement.entity.BorrowingRecord;
import com.tcs.library.librarymanagement.exception.NoBookAvailable;
import com.tcs.library.librarymanagement.repository.BookRepository;
import com.tcs.library.librarymanagement.repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("borrowingRecordService")
public class BorrowingRecordService implements IBorrowingRecordService {

    @Autowired
    BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Book borrowBook(Book book, String user) throws RuntimeException {
        List<Book> availableBooks = new ArrayList<>();
        try {
            availableBooks = bookRepository.getByIdAndStatus(book.getId(), book.getStatus());
        } catch (Exception e) {
            throw new NoBookAvailable("Something happens! try again");
        }

        if (!availableBooks.isEmpty()) {
            Book availableBook = availableBooks.get(0);
            BorrowingRecord borrowingRecord = new BorrowingRecord();
            borrowingRecord.setBook(availableBook);
            borrowingRecord.setBorrowingDate(LocalDate.now());
            borrowingRecord.setReturnDate(LocalDate.now().minusWeeks(2));
            borrowingRecord.setUser(user);
            borrowingRecordRepository.save(borrowingRecord);
            availableBook.setStatus(BookStatus.BORROWED);
            bookRepository.save(availableBook);
            return availableBook;
        } else {
            throw new NoBookAvailable("No book available");
        }
    }
}
