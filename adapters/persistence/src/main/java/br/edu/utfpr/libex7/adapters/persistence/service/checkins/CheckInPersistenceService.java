package br.edu.utfpr.libex7.adapters.persistence.service.checkins;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkins.CheckInEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.checkins.CheckInRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckInPersistenceService implements ICheckInPersistenceService {
	
	private final CheckInRepository repository;

	@Override
	public CheckInEntity register(CheckInEntity checkIn) {
		return repository.register(checkIn);
	}

	
}
