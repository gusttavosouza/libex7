package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class UserRepository<T extends UserEntity> extends GenericRepository<T, Long> {

	public UserRepository(EntityManager em) {
		super(em);
	}

	public List<T> findByName(String name) {
		Class<T> classType = getClassType();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(classType);
		Root<T> root = cq.from(classType);
		cq.select(root).where(cb.like(root.get("name"), name + "%"));
		TypedQuery<T> query = em.createQuery(cq);
		return query.getResultList();
	}

}
