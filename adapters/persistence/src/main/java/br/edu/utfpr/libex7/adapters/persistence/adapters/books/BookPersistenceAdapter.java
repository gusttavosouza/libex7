package br.edu.utfpr.libex7.adapters.persistence.adapters.books;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.books.BookPersistenceService;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.ports.out.books.RemoveBookPort;
import br.edu.utfpr.libex7.application.ports.out.books.SaveBookPort;
import br.edu.utfpr.libex7.application.ports.out.books.SearchBookPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookPersistenceAdapter implements SaveBookPort, SearchBookPort, RemoveBookPort {

	private final BookPersistenceService service;
	private final BookPersistenceMapper mapper;
	
	
	@Override
	public void remove(Long id) {
		service.remove(id);	
	}

	@Override
	public Optional<Book> findById(Long id) {
		Optional<BookEntity> optionalBook = service.findById(id);
		if(!optionalBook.isPresent()) {
			return Optional.empty();
		}
		BookEntity BookEntity = optionalBook.get();
		return Optional.ofNullable(mapper.mapToDomain(BookEntity));
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<BookEntity> bookEntities = service.findByTitle(title);
		List<Book> books = new LinkedList<>();
		bookEntities.forEach(c -> books.add(mapper.mapToDomain(c)));
		return books;
	}

	@Override
	public List<Book> findByAuthorName(String authorName) {
		List<BookEntity> bookEntities = service.findByAuthorName(authorName);
		return mapper.mapToDomain(bookEntities);
	}

	@Override
	public List<Book> findAll() {
		List<BookEntity> bookEntities = service.findAll();
		return mapper.mapToDomain(bookEntities);
	}

	@Override
	public Book save(Book book) {
		BookEntity bookEntity = mapper.mapToEntity(book);
		service.save(bookEntity);
		return mapper.mapToDomain(bookEntity);
	}

}
