package com.tcs.library.librarymanagement.service;

import java.util.Optional;

import com.tcs.library.librarymanagement.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.library.librarymanagement.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service("authorService")
public class AuthorService implements IAuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Author getAuthor(Long id) {
		// TODO Auto-generated method stub
		Optional<Author> author = authorRepository.findById(id);
		return author.orElse(null);
	}

	@Override
	public Author createAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		// TODO Auto-generated method stub
		 authorRepository.deleteById(id);;
	}

	@Override
	public Author updateAuthor(Author author) {
		// TODO Auto-generated method stub
		Optional<Author> authorDb = authorRepository.findById(author.getId());
        authorDb.ifPresent(value -> author.setId(value.getId()));
		return authorRepository.save(author);
	}

}
