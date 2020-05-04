package br.edu.utfpr.libex7.adapters.persistence.mapper.checkins;

import java.time.LocalDate;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkins.CheckInEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.checkouts.CheckOutPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckInPersistenceMapper implements GenericMapper<CheckIn, CheckInEntity> {
	
	private final CheckOutPersistenceMapper checkOutPersistenceMapper;

	@Override
	public CheckIn mapToDomain(CheckInEntity checkInEntity) {
		CheckOutEntity checkOutEntity = checkInEntity.getCheckout();
	    LocalDate checkInDate = checkInEntity.getCheckInDate();
		CheckOut checkout = checkOutPersistenceMapper.mapToDomain(checkOutEntity);
		return new CheckIn(checkout, checkInDate);
	}

	@Override
	public CheckInEntity mapToEntity(CheckIn checkIn) {
		CheckOut checkOut = checkIn.getCheckout();
	    LocalDate checkInDate = checkIn.getCheckInDate();
	    CheckOutEntity checkoutEntity = checkOutPersistenceMapper.mapToEntity(checkOut);
		return new CheckInEntity(checkoutEntity, checkInDate);
	}

}
