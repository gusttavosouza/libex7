package br.edu.utfpr.libex7.adapters.persistence.repository.checkins;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkins.CheckInEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class CheckInRepository extends GenericRepository<CheckInEntity, Long>{

	public CheckInRepository(EntityManager em) {
		super(em);
	}

	public CheckInEntity register(CheckInEntity checkIn) {
		return super.save(checkIn);
	}

}
