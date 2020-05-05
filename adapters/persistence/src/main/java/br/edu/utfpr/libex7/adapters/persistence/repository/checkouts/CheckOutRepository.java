package br.edu.utfpr.libex7.adapters.persistence.repository.checkouts;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckOutEntityId;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class CheckOutRepository extends GenericRepository<CheckOutEntity,CheckOutEntityId> {

	public CheckOutRepository(EntityManager em) {
		super(em);
	}


}
