package br.edu.utfpr.adapters.gui.configuration.copies;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.copies.CopyController;
import br.edu.utfpr.adapters.gui.controllers.copies.SaveCopyController;
import br.edu.utfpr.adapters.gui.controllers.copies.SearchCopyController;
import br.edu.utfpr.adapters.gui.views.copies.SaveCopyView;
import br.edu.utfpr.adapters.gui.views.copies.SearchCopyView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.copies.CopyPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.copies.CopyPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.copies.CopyRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.copies.CopyPersistenceService;
import br.edu.utfpr.libex7.application.ports.in.copies.SaveCopyUseCase;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import br.edu.utfpr.libex7.application.service.copies.SaveCopyService;
import br.edu.utfpr.libex7.application.service.copies.SearchCopyService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CopyConfiguration {
	
	
	public CopyController configure() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libex7");
		EntityManager entityManager = factory.createEntityManager();
		CopyRepository copyrRepository = new CopyRepository(entityManager);
		CopyPersistenceService service = new CopyPersistenceService(copyrRepository);
		CategoryPersistenceMapper categoryMapper = new CategoryPersistenceMapper();
		AuthorPersistenceMapper authorMapper = new AuthorPersistenceMapper();
		BookPersistenceMapper bookPersistenceMapper = new BookPersistenceMapper(categoryMapper, authorMapper);
		CopyPersistenceMapper mapper = new CopyPersistenceMapper(bookPersistenceMapper);
		CopyPersistenceAdapter adapter = new CopyPersistenceAdapter(service, mapper);
		
		SaveCopyUseCase saveCopyUseCase = new SaveCopyService(adapter);
		SaveCopyView saveCopyView = new SaveCopyView();
		
		SearchCopyUseCase searchCopyUseCase = new SearchCopyService(adapter);
		SearchCopyView searchCopyView = new SearchCopyView();
		
		SaveCopyController saveCopyController = new SaveCopyController(saveCopyUseCase, saveCopyView);
		SearchCopyController searchCopyController = new SearchCopyController(searchCopyUseCase, searchCopyView);
		
		
		return new CopyController(saveCopyController, searchCopyController);
	}

}
