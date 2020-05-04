package br.edu.utfpr.libex7.adapters.persistence.repository.copies;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class CopyRepository extends GenericRepository<CopyEntity, Long>{

	public CopyRepository(EntityManager em) {
		super(em);
	}

}
