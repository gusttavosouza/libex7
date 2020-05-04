package br.edu.utfpr.libex7.adapters.persistence.adapters.checkins;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkins.CheckInEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.checkins.CheckInPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.checkins.CheckInPersistenceService;
import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;
import br.edu.utfpr.libex7.application.ports.out.checkin.RegisterCheckInPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckInPersistenceAdapter implements RegisterCheckInPort{
	
	private final CheckInPersistenceService service;
	private final CheckInPersistenceMapper mapper;
	
	
	@Override
	public CheckIn register(CheckIn checkIn) {
		CheckInEntity checkInEntity = mapper.mapToEntity(checkIn);
		service.register(checkInEntity);
		return mapper.mapToDomain(checkInEntity);
	}

	

}
