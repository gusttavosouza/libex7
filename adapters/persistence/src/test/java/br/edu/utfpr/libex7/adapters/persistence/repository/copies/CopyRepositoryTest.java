package br.edu.utfpr.libex7.adapters.persistence.repository.copies;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.StatusCopyDataEnum;
import br.edu.utfpr.libex7.adapters.persistence.repository.books.BookRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.categories.CategoryRepository;

public class CopyRepositoryTest {

	private CopyRepository repository;
	
	private static EntityManagerFactory entityManagerFactory;
	
	private BookRepository bookRepository;
	private CategoryRepository categoryRepository;
	
	private CategoryEntity category;
	private BookEntity book;

	@BeforeAll
	public static void setupAll() {
		entityManagerFactory = Persistence.createEntityManagerFactory("libex7");
	}

	@BeforeEach
	public void setup() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		this.repository = new CopyRepository(entityManager);
		this.categoryRepository = new CategoryRepository(entityManager);
		this.bookRepository = new BookRepository(entityManager);
		
		category = new CategoryEntity();
		category.setDescription("Bar");
		
		this.categoryRepository.save(category);
		
		book = new BookEntity();
		book.setTitle("Foo");
		book.setYear(1994);
		book.setCategory(category);
		
		this.bookRepository.save(book);
	}

	@Test
	@DisplayName("Given New Book When Save Then Return Saved Book")
	public void givenNewBookWhenSaveThenReturnSavedBook() {

		CopyEntity copy = new CopyEntity();
		copy.setAcquisitionDate(LocalDate.now());
		copy.setBook(book);
		copy.setStatus(StatusCopyDataEnum.AVAILABLE);
		
		CopyEntity savedCopy = repository.save(copy);

		assertThat(savedCopy.getId()).isNotNull();
	}

	@Test
	@DisplayName("Given Existing Book When Find By Id Then Return Book")
	public void givenExistingBookWhenFindByIdThenReturnBook() {
		
		CopyEntity copy = new CopyEntity();
		copy.setAcquisitionDate(LocalDate.now());
		copy.setBook(book);
		copy.setStatus(StatusCopyDataEnum.AVAILABLE);
		
		CopyEntity savedCopy = repository.save(copy);


		Optional<BookEntity> optionalBookEntity = bookRepository.findById(savedCopy.getId());
		assertTrue(optionalBookEntity.isPresent());
	}

	@Test
	@DisplayName("Given Existing Book When Remove By Id Then Do Nothing")
	public void givenExistingBookWhenRemoveThenDoNothing() {
		CopyEntity copy = new CopyEntity();
		copy.setAcquisitionDate(LocalDate.now());
		copy.setBook(book);
		copy.setStatus(StatusCopyDataEnum.AVAILABLE);
		
		CopyEntity savedCopy = repository.save(copy);
		repository.remove(savedCopy.getId());
	}

	@Test
	@DisplayName("Given Existing Books When Find All Then Return Book List")
	public void givenExistingBooksWhenFindAllThenReturnBookList() {
		CopyEntity copy = new CopyEntity();
		copy.setAcquisitionDate(LocalDate.now());
		copy.setBook(book);
		copy.setStatus(StatusCopyDataEnum.AVAILABLE);

	    repository.save(copy);
		List<CopyEntity> copyEntities = repository.findAll();
		assertFalse(copyEntities.isEmpty());
	}
}
