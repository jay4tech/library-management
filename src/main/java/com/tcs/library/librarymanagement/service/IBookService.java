package com.tcs.library.librarymanagement.service;

import com.tcs.library.librarymanagement.entity.Book;

public interface IBookService {

	Book getBook(Long id);

	Book createBook(Book book);

	void deleteBook(Long id);

	Book updateBook(Book book);

}
