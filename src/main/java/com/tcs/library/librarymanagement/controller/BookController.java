package com.tcs.library.librarymanagement.controller;

import com.tcs.library.librarymanagement.entity.Book;
import com.tcs.library.librarymanagement.entity.BorrowingRecord;
import com.tcs.library.librarymanagement.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tcs.library.librarymanagement.service.IBookService;


@RestController
@RequestMapping(path ="book")
public class BookController {

    @Autowired
    IBookService bookService;

    /**
     * This Api is used to get the book on id
     *
     * @param id
     * @return Book
     */
    @GetMapping(path ="/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    /**
     * This API is used to create the book
     *
     * @param book
     * @return Book
     */
    @PostMapping(path ="/")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    /**
     * This API is used to delete the bool
     *
     * @param id
     */
    @DeleteMapping(path ="/")
    public void deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
    }

    /**
     * This API is used to update the book
     *
     * @param book
     * @return Book
     */
    @PutMapping(path ="/")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
    @Autowired
    BorrowingRecordService borrowingRecordService;

    /**
     * This API used to borrow books
     *
     * @param book
     * @return Book
     */
    @PostMapping(path = "/borrow/{user}")
    public Book borrowBook(@RequestBody Book book, @PathVariable String user) {
        return borrowingRecordService.borrowBook(book, user);
    }
}
