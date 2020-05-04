package br.edu.utfpr.libex7.adapters.persistence.service.checkouts;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;

public interface ICheckOutPersistenceService {
	
	CheckOutEntity register(CheckOutEntity checkout);

}
