package br.edu.utfpr.libex7.adapters.persistence.adapters.copies;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.StatusCopyDataEnum;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.copies.CopyPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.copies.CopyPersistenceService;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;

public class CopyPersistenceAdapterTest {

	private CopyPersistenceService service;
	private CategoryPersistenceMapper categoryMapper;
	private AuthorPersistenceMapper authorMapper;
	private BookPersistenceMapper bookPersistenceMapper;
	private CopyPersistenceMapper mapper;
	private CopyPersistenceAdapter adapter;

	@BeforeEach
	public void setup() {
		this.service = mock(CopyPersistenceService.class);
		this.categoryMapper = new CategoryPersistenceMapper();
		this.authorMapper = new AuthorPersistenceMapper();
		this.bookPersistenceMapper = new BookPersistenceMapper(categoryMapper, authorMapper);
		this.mapper = new CopyPersistenceMapper(bookPersistenceMapper);
		this.adapter = new CopyPersistenceAdapter(service, mapper);
	}

	@Test
	@DisplayName("Given New Copy When Save Then Return Saved Copy")
	public void givenNewCopyWhenSaveThenReturnSavedCopy() {
		CopyEntity copyEntity = new CopyEntity(1L);
		copyEntity.setStatus(StatusCopyDataEnum.AVAILABLE);
		BookEntity bookEntity = new BookEntity(1L);
		bookEntity.setCategory(new CategoryEntity(1L));
		copyEntity.setBook(bookEntity);
		
		when(service.save(any(CopyEntity.class))).thenReturn(copyEntity);
		
		Copy copy = new Copy(1L);
		copy.setStatus(StatusCopyEnum.AVAILABLE);
		Book book = new Book(1L);
		book.setCategory(new Category(1L));
		copy.setBook(book);
		

		Copy savedCopy = adapter.save(copy);
		assertThat(savedCopy).isNotNull();
	}

	@Test
	@DisplayName("Given Copy Id When Exists Then Return Copy")
	public void givenCopyIdWhenExistsThenReturnCopy() {
		CopyEntity copyEntity = new CopyEntity(1L);
		copyEntity.setStatus(StatusCopyDataEnum.AVAILABLE);
		BookEntity bookEntity = new BookEntity(1L);
		bookEntity.setCategory(new CategoryEntity(1L));
		copyEntity.setBook(bookEntity);
		when(service.findById(anyLong())).thenReturn(Optional.ofNullable(copyEntity));
		Optional<Copy> optionalCopy = adapter.findById(1L);
		assertTrue(optionalCopy.isPresent());
	}

	@Test
	@DisplayName("Given Copy Id When Not Exists Then Return Copy")
	public void givenCopyIdWhenNotExistsThenReturnCopy() {
		when(service.findById(anyLong())).thenReturn(Optional.ofNullable(null));
		Optional<Copy> optionalCopy = adapter.findById(1L);
		assertFalse(optionalCopy.isPresent());
	}

	@Test
	@DisplayName("Given Find All Method When Is Called Then Return Copy List")
	public void givenFindAllMethodWhenIsCalledThenReturnCopyList() {
		CopyEntity copyEntity = new CopyEntity(1L);
		copyEntity.setStatus(StatusCopyDataEnum.AVAILABLE);
		BookEntity bookEntity = new BookEntity(1L);
		bookEntity.setCategory(new CategoryEntity(1L));
		copyEntity.setBook(bookEntity);
		when(service.findAll()).thenReturn(Arrays.asList(copyEntity));
		List<Copy> copies = adapter.findAll();
		assertFalse(copies.isEmpty());
	}

	@Test
	@DisplayName("Given Existing Copy When Remove Then Do Nothing")
	public void givenExistingCopyWhenRemoveThenDoNothing() {
		adapter.remove(1L);
		verify(service, times(1)).remove(anyLong());
	}
}
