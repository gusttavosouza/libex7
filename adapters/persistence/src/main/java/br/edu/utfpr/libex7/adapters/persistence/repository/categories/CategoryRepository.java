package br.edu.utfpr.libex7.adapters.persistence.repository.categories;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class CategoryRepository extends GenericRepository<CategoryEntity, Long> {

    public CategoryRepository(EntityManager em) {
        super(em);
    }

	public List<CategoryEntity> findByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
