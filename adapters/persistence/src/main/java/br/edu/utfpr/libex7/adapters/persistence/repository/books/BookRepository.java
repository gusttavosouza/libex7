package br.edu.utfpr.libex7.adapters.persistence.repository.books;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class BookRepository extends GenericRepository<BookEntity, Long> {

    public BookRepository(EntityManager em) {
        super(em);
    }

	public List<BookEntity> findByTitle(String title) {
		Class<BookEntity> classType = getClassType();
	    CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BookEntity> cq = cb.createQuery(classType);
        Root<BookEntity> root = cq.from(classType);
        cq.select(root)
        	.where(cb.equal(root.get("title"), title));
        TypedQuery<BookEntity> allQuery = em.createQuery(cq);
        return allQuery.getResultList();
	}
	
	public List<BookEntity> findByAuthorName(String authorName) {
		Class<BookEntity> classType = getClassType();
	    CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BookEntity> cq = cb.createQuery(classType);
        Root<BookEntity> root = cq.from(classType);
        Join<Object, Object> join = root.join("authors", JoinType.INNER);
        cq.select(root)
    	.where(cb.equal(join.get("name"), authorName));
        TypedQuery<BookEntity> query = em.createQuery(cq);
        return query.getResultList();
	}

   
}
