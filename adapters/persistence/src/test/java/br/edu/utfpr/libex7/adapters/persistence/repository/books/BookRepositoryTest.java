package br.edu.utfpr.libex7.adapters.persistence.repository.books;

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
import br.edu.utfpr.libex7.adapters.persistence.repository.categories.CategoryRepository;

public class BookRepositoryTest {

	private BookRepository repository;
	private CategoryRepository categoryRepository;
	private static EntityManagerFactory entityManagerFactory;
	
	private CategoryEntity category;

	@BeforeAll
	public static void setupAll() {
		entityManagerFactory = Persistence.createEntityManagerFactory("libex7");
	}

	@BeforeEach
	public void setup() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		this.categoryRepository = new CategoryRepository(entityManager);
		this.repository = new BookRepository(entityManager);
		
		category = new CategoryEntity();
		category.setDescription("Bar");
		
		
		
		this.categoryRepository.save(category);
	}

	@Test
	@DisplayName("Given New Book When Save Then Return Saved Book")
	public void givenNewBookWhenSaveThenReturnSavedBook() {
		BookEntity book = new BookEntity();
		book.setTitle("Foo");
		book.setYear(1994);
		book.setCategory(category);
		
		CopyEntity copy = new CopyEntity();
		copy.setAcquisitionDate(LocalDate.now());
		copy.setBook(book);
		copy.setStatus(StatusCopyDataEnum.AVAILABLE);
		
		book.addCopy(copy);

		BookEntity savedBook = this.repository.save(book);
		assertThat(savedBook.getId()).isNotNull();
	}

	@Test
	@DisplayName("Given Existing Book When Find By Id Then Return Book")
	public void givenExistingBookWhenFindByIdThenReturnBook() {
		BookEntity book = new BookEntity();
		book.setTitle("Foo");
		book.setYear(1994);
		book.setCategory(category);

		BookEntity savedBook = this.repository.save(book);

		Optional<BookEntity> optionalBookEntity = repository.findById(savedBook.getId());
		assertTrue(optionalBookEntity.isPresent());
	}

	@Test
	@DisplayName("Given Existing Book When Remove By Id Then Do Nothing")
	public void givenExistingBookWhenRemoveThenDoNothing() {
		BookEntity book = new BookEntity();
		book.setTitle("Foo");
		book.setYear(1994);
		book.setCategory(category);

		BookEntity savedBook = this.repository.save(book);
		repository.remove(savedBook.getId());
	}

	@Test
	@DisplayName("Given Existing Books When Find All Then Return Book List")
	public void givenExistingBooksWhenFindAllThenReturnBookList() {
		BookEntity book = new BookEntity();
		book.setTitle("Foo");
		book.setYear(1994);
		book.setCategory(category);
		this.repository.save(book);

		List<BookEntity> bookEntities = repository.findAll();
		assertFalse(bookEntities.isEmpty());
	}
}
