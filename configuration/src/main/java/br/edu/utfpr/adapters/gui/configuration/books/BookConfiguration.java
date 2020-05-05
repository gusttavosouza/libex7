package br.edu.utfpr.adapters.gui.configuration.books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.books.SaveBookController;
import br.edu.utfpr.adapters.gui.controllers.books.SearchBookController;
import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.books.BookPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.books.BookRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.books.BookPersistenceService;
import br.edu.utfpr.libex7.application.ports.in.books.SaveBookUseCase;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import br.edu.utfpr.libex7.application.service.books.SaveBookService;
import br.edu.utfpr.libex7.application.service.books.SearchBookService;
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
		
		SaveBookController saveBookController = new SaveBookController(saveBookUseCase, saveBookView);
		SearchBookController searchBookController = new SearchBookController(searchBookUseCase, searchBookView);
		
		
		return new BookController(saveBookController, searchBookController);
	}

}
