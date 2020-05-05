package br.edu.utfpr.libex7.adapters.persistence.service.checkouts;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckOutEntityId;

public interface ICheckOutPersistenceService {
	
	CheckOutEntity save(CheckOutEntity checkout);
	Optional<CheckOutEntity> findById(CheckOutEntityId checkOutId);
	List<CheckOutEntity> findAll();

}
