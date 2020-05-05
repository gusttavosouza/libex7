package br.edu.utfpr.adapters.gui.configuration.authors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.authors.SaveAuthorController;
import br.edu.utfpr.adapters.gui.controllers.authors.SearchAuthorController;
import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.author.AuthorPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.authors.AuthorRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.authors.AuthorPersistenceService;
import br.edu.utfpr.libex7.application.ports.in.authors.SaveAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import br.edu.utfpr.libex7.application.service.authors.SaveAuthorService;
import br.edu.utfpr.libex7.application.service.authors.SearchAuthorService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorConfiguration {
	
	
	public AuthorController configure() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libex7");
		EntityManager entityManager = factory.createEntityManager();
		AuthorRepository authorRepository = new AuthorRepository(entityManager);
		AuthorPersistenceService service = new AuthorPersistenceService(authorRepository);
		AuthorPersistenceMapper mapper = new AuthorPersistenceMapper();
		AuthorPersistenceAdapter adapter = new AuthorPersistenceAdapter(service, mapper);
		
		SaveAuthorUseCase saveAuthorUseCase = new SaveAuthorService(adapter);
		SaveAuthorView saveAuthorView = new SaveAuthorView();
		
		SearchAuthorUseCase searchAuthorUseCase = new SearchAuthorService(adapter);
		SearchAuthorView searchAuthorView = new SearchAuthorView();
		
		SaveAuthorController saveAuthorController = new SaveAuthorController(saveAuthorUseCase, saveAuthorView);
		SearchAuthorController searchAuthorController = new SearchAuthorController(searchAuthorUseCase, searchAuthorView);
		
		
		return new AuthorController(saveAuthorController, searchAuthorController);
	}

}
