package br.edu.utfpr.libex7.adapters.persistence.adapters.categories;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.categories.CategoryPersistenceService;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.out.categories.RemoveCategoryPort;
import br.edu.utfpr.libex7.application.ports.out.categories.SaveCategoryPort;
import br.edu.utfpr.libex7.application.ports.out.categories.SearchCategoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements SaveCategoryPort, SearchCategoryPort, RemoveCategoryPort {

	
	private final CategoryPersistenceService service;
	private final CategoryPersistenceMapper mapper;
	
	@Override
	public void remove(Long id) {
		service.remove(id);
	}

	@Override
	public Optional<Category> findById(Long id) {
		Optional<CategoryEntity> optionalCategory = service.findById(id);
		if(!optionalCategory.isPresent()) {
			return Optional.empty();
		}
		CategoryEntity categoryEntity = optionalCategory.get();
		return Optional.ofNullable(mapper.mapToDomain(categoryEntity));
	}

	@Override
	public List<Category> findByDescription(String description) {
		List<CategoryEntity> categoryEntities = service.findByDescription(description);
		return mapper.mapToDomain(categoryEntities);
	}

	@Override
	public List<Category> findAll() {
		List<CategoryEntity> categoryEntities = service.findAll();
		return mapper.mapToDomain(categoryEntities);
	}

	@Override
	public Category save(Category category) {
		CategoryEntity categoryEntity = mapper.mapToEntity(category);
		service.save(categoryEntity);
		return mapper.mapToDomain(categoryEntity);
	}

}
