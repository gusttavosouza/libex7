package br.edu.utfpr.adapters.gui.configuration.books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.books.SaveBookController;
import br.edu.utfpr.adapters.gui.controllers.books.SearchBookController;
import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.author.AuthorPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.adapters.books.BookPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.adapters.categories.CategoryPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.authors.AuthorRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.books.BookRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.categories.CategoryRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.authors.AuthorPersistenceService;
import br.edu.utfpr.libex7.adapters.persistence.service.books.BookPersistenceService;
import br.edu.utfpr.libex7.adapters.persistence.service.categories.CategoryPersistenceService;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.in.books.SaveBookUseCase;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import br.edu.utfpr.libex7.application.service.authors.SearchAuthorService;
import br.edu.utfpr.libex7.application.service.books.SaveBookService;
import br.edu.utfpr.libex7.application.service.books.SearchBookService;
import br.edu.utfpr.libex7.application.service.categories.SearchCategoryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookConfiguration {
	
	
	public BookController configure() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libex7");
		EntityManager entityManager = factory.createEntityManager();
		BookRepository bookrRepository = new BookRepository(entityManager);
		BookPersistenceService service = new BookPersistenceService(bookrRepository);
		CategoryPersistenceMapper categoryMapper = new CategoryPersistenceMapper();
		AuthorPersistenceMapper authorMapper = new AuthorPersistenceMapper();
		BookPersistenceMapper mapper = new BookPersistenceMapper(categoryMapper, authorMapper);
		BookPersistenceAdapter adapter = new BookPersistenceAdapter(service, mapper);
		
		SaveBookUseCase saveBookUseCase = new SaveBookService(adapter);
		SaveBookView saveBookView = new SaveBookView();
		
		SearchBookUseCase searchBookUseCase = new SearchBookService(adapter);
		SearchBookView searchBookView = new SearchBookView();
		
		
		CategoryRepository categoryRepository = new CategoryRepository(entityManager);
		CategoryPersistenceService categoryPersistenceService = new CategoryPersistenceService(categoryRepository);
		CategoryPersistenceMapper categoryPersistenceMapper = new CategoryPersistenceMapper();
		CategoryPersistenceAdapter categoryPersistenceAdapter = new CategoryPersistenceAdapter(categoryPersistenceService, categoryPersistenceMapper);
		SearchCategoryUseCase serCategoryUseCase = new SearchCategoryService(categoryPersistenceAdapter);
		
		
		AuthorRepository authorRepository = new AuthorRepository(entityManager);
		AuthorPersistenceService authorPersistenceService = new AuthorPersistenceService(authorRepository);
		AuthorPersistenceMapper authorPersistenceMapper = new AuthorPersistenceMapper();
		AuthorPersistenceAdapter authorPersistenceAdapter = new AuthorPersistenceAdapter(authorPersistenceService, authorPersistenceMapper);
		SearchAuthorUseCase searchAuthorUseCase = new SearchAuthorService(authorPersistenceAdapter);
		
		SaveBookController saveBookController = new SaveBookController(saveBookUseCase, serCategoryUseCase, searchAuthorUseCase, saveBookView);
		SearchBookController searchBookController = new SearchBookController(searchBookUseCase, searchBookView);
		
		
		return new BookController(saveBookController, searchBookController);
	}

}
