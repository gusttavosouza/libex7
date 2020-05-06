package br.edu.utfpr.libex7.adapters.persistence.repository.categories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class CategoryRepository extends GenericRepository<CategoryEntity, Long> {

	public CategoryRepository(EntityManager em) {
		super(em);
	}

	public List<CategoryEntity> findByDescription(String description) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CategoryEntity> cq = cb.createQuery(CategoryEntity.class);
		Root<CategoryEntity> root = cq.from(CategoryEntity.class);
		cq.select(root)
		  .where(cb.like(root.get("description"), description + "%"));
		TypedQuery<CategoryEntity> query = em.createQuery(cq);
		return query.getResultList();
	}

}
