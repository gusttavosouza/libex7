package br.edu.utfpr.libex7.adapters.persistence.mapper.checkouts;

import java.time.LocalDate;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkins.CheckInEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckOutEntityId;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.checkins.CheckInPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.UserPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOutPersistenceMapper implements GenericMapper<CheckOut, CheckOutEntity> {

	private final UserPersistenceMapper<User, UserEntity> userMapper;
	private final CheckInPersistenceMapper checkInMapper;

	@Override
	public CheckOut mapToDomain(CheckOutEntity checkOutEntity) {
		CheckInEntity checkInEntity = checkOutEntity.getCheckIn();
		CheckIn checkIn = checkInMapper.mapToDomain(checkInEntity);
		CheckOutEntityId checkOutId = checkOutEntity.getCheckOutId();
		LocalDate checkOutDate = checkOutId.getCheckOutDate();
		UserEntity userEntity = checkOutId.getUser();
		LocalDate expectedCheckInDate = checkOutEntity.getExpectedCheckInDate();
		User user = userMapper.mapToDomain(userEntity);
		CheckOut checkOut = new CheckOut(user, checkOutDate);
		checkOut.setExpectedCheckInDate(expectedCheckInDate);
		checkOut.setCheckIn(checkIn);
		return checkOut;
	}

	@Override
	public CheckOutEntity mapToEntity(CheckOut checkOut) {
		CheckIn checkIn = checkOut.getCheckIn();
		CheckInEntity checkInEntity = checkInMapper.mapToEntity(checkIn);
		LocalDate checkOutDate = checkOut.getCheckOutDate();
		LocalDate expectedCheckInDate = checkOut.getExpectedCheckInDate();
		User user = checkOut.getUser();
		UserEntity userEntity = userMapper.mapToEntity(user);
		CheckOutEntity.CheckOutEntityId checkOutEntityId = new CheckOutEntityId(userEntity, checkOutDate);
		CheckOutEntity checkOutEntity = new CheckOutEntity(checkOutEntityId);
		checkOutEntity.setExpectedCheckInDate(expectedCheckInDate);
		checkOutEntity.setCheckIn(checkInEntity);
		return checkOutEntity;
	}

}
