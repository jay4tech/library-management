package com.tcs.library.librarymanagement.service;

import com.tcs.library.librarymanagement.entity.Author;

public interface IAuthorService {

	Author getAuthor(Long id);

	Author createAuthor(Author author);

	void deleteAuthor(Long id);

	Author updateAuthor(Author author);

}
