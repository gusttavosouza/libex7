package br.edu.utfpr.libex7.adapters.persistence.service.checkouts;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.checkouts.CheckOutRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOutPersistenceService implements ICheckOutPersistenceService {
	
	private final CheckOutRepository repository;

	@Override
	public CheckOutEntity register(CheckOutEntity checkout) {
		return repository.register(checkout);
	}

}
