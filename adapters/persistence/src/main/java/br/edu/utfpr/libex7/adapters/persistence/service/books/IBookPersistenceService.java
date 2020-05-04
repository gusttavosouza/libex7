package br.edu.utfpr.libex7.adapters.persistence.service.books;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;

public interface IBookPersistenceService {
	void remove(Long id);
	Optional<BookEntity> findById(Long id);
	List<BookEntity> findByTitle(String title);
	List<BookEntity> findByAuthorName(String authorName);
	List<BookEntity> findAll();
	BookEntity save(BookEntity book);
}
