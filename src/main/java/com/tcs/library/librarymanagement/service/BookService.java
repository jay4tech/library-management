package com.tcs.library.librarymanagement.service;

import com.tcs.library.librarymanagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.library.librarymanagement.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("bookService")
public class BookService implements IBookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book getBook(Long id) {
		// TODO Auto-generated method stub
		Optional<Book> book = bookRepository.findById(id);
		return book.orElse(null);
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		Optional<Book>  bookDb = bookRepository.findById(book.getId());
		bookDb.ifPresent(value -> book.setId(value.getId()));
		return bookRepository.save(book);
	}

}
