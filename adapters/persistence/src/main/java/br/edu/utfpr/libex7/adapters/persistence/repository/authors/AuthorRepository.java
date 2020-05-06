package br.edu.utfpr.libex7.adapters.persistence.repository.authors;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class AuthorRepository extends GenericRepository<AuthorEntity, Long> {

    public AuthorRepository(EntityManager em) {
        super(em);
    }

	public List<AuthorEntity> findByName(String name) {
		   CriteriaBuilder cb = em.getCriteriaBuilder();
	       CriteriaQuery<AuthorEntity> cq = cb.createQuery(AuthorEntity.class);
	       Root<AuthorEntity> root = cq.from(AuthorEntity.class);
	       cq.select(root)
	          .where(cb.like(root.get("name"), name + "%"));
	       TypedQuery<AuthorEntity> query = em.createQuery(cq);
	       return query.getResultList();
	}

   
}
