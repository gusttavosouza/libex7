package br.edu.utfpr.libex7.adapters.persistence.mapper.checkouts;

import java.time.LocalDate;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.UserPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOutPersistenceMapper implements GenericMapper<CheckOut, CheckOutEntity>{
	
	private final UserPersistenceMapper<User, UserEntity> mapper;

	@Override
	public CheckOut mapToDomain(CheckOutEntity checkOutEntity) {
		LocalDate checkInDate = checkOutEntity.getCheckInDate();
		LocalDate checkOutDate = checkOutEntity.getCheckOutDate();
		LocalDate expectedCheckInDate = checkOutEntity.getExpectedCheckInDate();
		UserEntity userEntity = checkOutEntity.getUser();
		User user = mapper.mapToDomain(userEntity);
		CheckOut checkOut = new CheckOut(user, checkOutDate);
		checkOut.setExpectedCheckInDate(expectedCheckInDate);
		checkOut.setCheckInDate(checkInDate);
		return checkOut;
	}

	@Override
	public CheckOutEntity mapToEntity(CheckOut checkOut) {
		LocalDate checkInDate = checkOut.getCheckInDate();
		LocalDate checkOutDate = checkOut.getCheckOutDate();
		LocalDate expectedCheckInDate = checkOut.getExpectedCheckInDate();
		User user = checkOut.getUser();
		UserEntity userEntity = mapper.mapToEntity(user);
		CheckOutEntity checkOutEntity = new CheckOutEntity(userEntity, checkOutDate);
		checkOutEntity.setExpectedCheckInDate(expectedCheckInDate);
		checkOutEntity.setCheckInDate(checkInDate);
		return checkOutEntity;
	}

}
