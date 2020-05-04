package br.edu.utfpr.libex7.adapters.persistence.service.categories;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;

public interface ICategoryPersistenceService {

	void remove(Long id);
	Optional<CategoryEntity> findById(Long id);
	List<CategoryEntity> findByDescription(String description);
	List<CategoryEntity> findAll();
	CategoryEntity save(CategoryEntity category);

}
