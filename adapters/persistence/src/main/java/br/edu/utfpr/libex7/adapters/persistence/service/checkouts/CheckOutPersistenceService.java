package br.edu.utfpr.libex7.adapters.persistence.service.checkouts;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckOutEntityId;
import br.edu.utfpr.libex7.adapters.persistence.repository.checkouts.CheckOutRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOutPersistenceService implements ICheckOutPersistenceService {
	
	private final CheckOutRepository repository;

	@Override
	public CheckOutEntity save(CheckOutEntity checkout) {
		return repository.save(checkout);
	}

	@Override
	public Optional<CheckOutEntity> findById(CheckOutEntityId checkOutId) {
		return repository.findById(checkOutId);
	}

	@Override
	public List<CheckOutEntity> findAll() {
		return repository.findAll();
	}

}
