package br.edu.utfpr.libex7.adapters.persistence.repository.checkouts;

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
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.StatusCopyDataEnum;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.books.BookRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.categories.CategoryRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.UserRepository;

public class CheckOutRepositoryTest {

	private UserRepository userRepository;
	private BookRepository bookRepository;
    private CheckOutRepository repository;
	private CategoryRepository categoryRepository;
	private static EntityManagerFactory entityManagerFactory;
	
	private CategoryEntity category;
	private BookEntity book;
	private UserEntity user;

	@BeforeAll
	public static void setupAll() {
		entityManagerFactory = Persistence.createEntityManagerFactory("libex7");
	}

	@BeforeEach
	public void setup() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		this.categoryRepository = new CategoryRepository(entityManager);
		this.bookRepository = new BookRepository(entityManager);
		this.userRepository = new UserRepository(entityManager);
		this.repository = new CheckOutRepository(entityManager);
		
		category = new CategoryEntity();
		category.setDescription("Bar");
		
		
		this.categoryRepository.save(category);
		
		book = new BookEntity();
		book.setTitle("Foo");
		book.setYear(1994);
		book.setCategory(category);
		
		CopyEntity copy = new CopyEntity();
		copy.setAcquisitionDate(LocalDate.now());
		copy.setBook(book);
		copy.setStatus(StatusCopyDataEnum.AVAILABLE);
		
		book.addCopy(copy);

		this.bookRepository.save(book);
		
		user = new StudentEntity();
		user.setName("Foo");
		user.setDob(LocalDate.now());
		
		userRepository.save(user);	
	}

	@Test
	@DisplayName("Given New CheckOut When Save Then Return Saved CheckOut")
	public void givenCheckOutBookWhenSaveThenReturnSavedCheckOut() {
		
		CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(user, LocalDate.now());
		CheckOutEntity checkOutEntity = new CheckOutEntity(checkOutId);
		checkOutEntity.setExpectedCheckInDate(LocalDate.now());
		
		CheckOutEntity savedCheckOutEntity = repository.save(checkOutEntity);
		
		savedCheckOutEntity.setCheckIn(savedCheckOutEntity.new CheckInEntity(LocalDate.now()));
		
		repository.save(savedCheckOutEntity);
		assertThat(savedCheckOutEntity).isNotNull();
	}

	@Test
	@DisplayName("Given Existing CheckOut When Find By Id Then Return CheckOut")
	public void givenExistingCheckoutWhenFindByIdThenReturnCheckOut() {
		CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(user, LocalDate.now());
		CheckOutEntity checkOutEntity = new CheckOutEntity(checkOutId);
		checkOutEntity.setExpectedCheckInDate(LocalDate.now());
		
		CheckOutEntity savedCheckOutEntity = repository.save(checkOutEntity);

	    Optional<CheckOutEntity> optionalCheckout = repository.findById(savedCheckOutEntity.getCheckOutId());
		assertTrue(optionalCheckout.isPresent());
	}

	@Test
	@DisplayName("Given Existing CheckOut When Remove By Id Then Do Nothing")
	public void givenExistingCheckOutWhenRemoveThenDoNothing() {
		CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(user, LocalDate.now());
		CheckOutEntity checkOutEntity = new CheckOutEntity(checkOutId);
		checkOutEntity.setExpectedCheckInDate(LocalDate.now());
		
		CheckOutEntity savedCheckOutEntity = repository.save(checkOutEntity);

		repository.remove(savedCheckOutEntity.getCheckOutId());
	}

	@Test
	@DisplayName("Given Existing CheckOuts When Find All Then Return CheckOut List")
	public void givenExistingCheckOutsWhenFindAllThenReturnCheckOutList() {
		CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(user, LocalDate.now());
		CheckOutEntity checkOutEntity = new CheckOutEntity(checkOutId);
		checkOutEntity.setExpectedCheckInDate(LocalDate.now());
		
		repository.save(checkOutEntity);

		List<CheckOutEntity> checkoutEntities = repository.findAll();
		assertFalse(checkoutEntities.isEmpty());
	}
}
