package br.edu.utfpr.libex7.adapters.persistence.service.checkins;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkins.CheckInEntity;

public interface ICheckInPersistenceService {
	CheckInEntity register (CheckInEntity checkIn);
}
