package br.edu.utfpr.adapters.gui.configuration.categories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.categories.CategoryController;
import br.edu.utfpr.adapters.gui.controllers.categories.SaveCategoryController;
import br.edu.utfpr.adapters.gui.controllers.categories.SearchCategoryController;
import br.edu.utfpr.adapters.gui.views.categories.SaveCategoryView;
import br.edu.utfpr.adapters.gui.views.categories.SearchCategoryView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.categories.CategoryPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.categories.CategoryRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.categories.CategoryPersistenceService;
import br.edu.utfpr.libex7.application.ports.in.categories.SaveCategoryUseCase;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import br.edu.utfpr.libex7.application.service.categories.SaveCategoryService;
import br.edu.utfpr.libex7.application.service.categories.SearchCategoryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryConfiguration {
	
	
	public CategoryController configure() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libex7");
		EntityManager entityManager = factory.createEntityManager();
		CategoryRepository categoryRepository = new CategoryRepository(entityManager);
		CategoryPersistenceService service = new CategoryPersistenceService(categoryRepository);
		CategoryPersistenceMapper mapper = new CategoryPersistenceMapper();
		CategoryPersistenceAdapter adapter = new CategoryPersistenceAdapter(service, mapper);
		
		SaveCategoryUseCase saveCategoryUseCase = new SaveCategoryService(adapter);
		SaveCategoryView saveCategoryView = new SaveCategoryView();
		
		SearchCategoryUseCase searchCategoryUseCase = new SearchCategoryService(adapter);
		SearchCategoryView searchCategoryView = new SearchCategoryView();
		
		SaveCategoryController saveCategoryController = new SaveCategoryController(saveCategoryUseCase, saveCategoryView);
		SearchCategoryController searchCategoryController = new SearchCategoryController(searchCategoryUseCase, searchCategoryView);
		
		
		return new CategoryController(saveCategoryController, searchCategoryController);
	}

}
