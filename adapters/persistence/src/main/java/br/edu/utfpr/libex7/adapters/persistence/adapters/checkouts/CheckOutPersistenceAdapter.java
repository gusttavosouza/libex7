package br.edu.utfpr.libex7.adapters.persistence.adapters.checkouts;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.checkouts.CheckOutPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.checkouts.CheckOutPersistenceService;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.ports.out.checkout.RegisterCheckOutPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOutPersistenceAdapter implements RegisterCheckOutPort{
	
	private final CheckOutPersistenceService service;
	private final CheckOutPersistenceMapper mapper;
	
	
	@Override
	public CheckOut register(CheckOut checkIn) {
		CheckOutEntity checkOutEntity = mapper.mapToEntity(checkIn);
		service.register(checkOutEntity);
		return mapper.mapToDomain(checkOutEntity);
	}

	

}
