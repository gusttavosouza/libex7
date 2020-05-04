package br.edu.utfpr.libex7.adapters.persistence.mapper.categories;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.application.domain.categories.Category;

public class CategoryPersistenceMapper implements GenericMapper<Category, CategoryEntity>{

	@Override
	public Category mapToDomain(CategoryEntity categoryEntity) {
		Long id = categoryEntity.getId();
		String description = categoryEntity.getDescription();
		Category category = new Category(id);
		category.setDescription(description);
		return category;
	}

	@Override
	public CategoryEntity mapToEntity(Category category) {
		Long id = category.getId();
		String description = category.getDescription();
		CategoryEntity categoryEntity = new CategoryEntity(id);
		categoryEntity.setDescription(description);
		return categoryEntity;
	}

}
