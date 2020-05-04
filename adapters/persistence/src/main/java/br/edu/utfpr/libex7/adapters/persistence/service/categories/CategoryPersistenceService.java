package br.edu.utfpr.libex7.adapters.persistence.service.categories;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.categories.CategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryPersistenceService implements ICategoryPersistenceService {

	
	private final CategoryRepository repository;
	
	@Override
	public void remove(Long id) {
		repository.remove(id);
	}

	@Override
	public Optional<CategoryEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<CategoryEntity> findByDescription(String description) {
		return repository.findByDescription(description);
	}

	@Override
	public List<CategoryEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public CategoryEntity save(CategoryEntity category) {
		return repository.save(category);
	}

}
