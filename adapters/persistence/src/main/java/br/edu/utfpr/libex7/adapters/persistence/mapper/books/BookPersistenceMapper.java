package br.edu.utfpr.libex7.adapters.persistence.mapper.books;

import java.util.List;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookPersistenceMapper implements GenericMapper<Book, BookEntity> {

	
	private final CategoryPersistenceMapper categoryMapper;
	private final AuthorPersistenceMapper authorMapper;
	
	@Override
	public Book mapToDomain(BookEntity bookEntity) {
		Long id = bookEntity.getId();
		String title = bookEntity.getTitle();
		Integer year = bookEntity.getYear();
		CategoryEntity category = bookEntity.getCategory();
		List<AuthorEntity> authors = bookEntity.getAuthors();
		Book book = new Book(id);
		book.setTitle(title);
		book.setYear(year);
		book.setCategory(categoryMapper.mapToDomain(category));
		authors.forEach(a -> book.addAuthor(authorMapper.mapToDomain(a)));
		return book;
	}

	@Override
	public BookEntity mapToEntity(Book book) {
		Long id = book.getId();
		String title = book.getTitle();
		Integer year = book.getYear();
		Category category = book.getCategory();
		List<Author> authors = book.getAuthors();
		BookEntity bookEntity = new BookEntity(id);
		bookEntity.setTitle(title);
		bookEntity.setYear(year);
		bookEntity.setCategory(categoryMapper.mapToEntity(category));
		authors.forEach(a -> bookEntity.addAuthor(authorMapper.mapToEntity(a)));
		return bookEntity;
	}

}
