package br.edu.utfpr.libex7.adapters.persistence.repository.checkouts;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class CheckOutRepository extends GenericRepository<CheckOutEntity,Long> {

	public CheckOutRepository(EntityManager em) {
		super(em);
	}

	public CheckOutEntity register(CheckOutEntity checkout) {
		return super.save(checkout);
	}

}
