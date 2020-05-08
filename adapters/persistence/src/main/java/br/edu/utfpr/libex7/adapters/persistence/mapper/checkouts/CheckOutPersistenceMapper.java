package br.edu.utfpr.libex7.adapters.persistence.mapper.checkouts;

import java.time.LocalDate;
import java.util.List;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckInEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckOutEntityId;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.copies.CopyPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.UserPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut.CheckIn;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOutPersistenceMapper extends GenericMapper<CheckOut, CheckOutEntity> {
	

	@SuppressWarnings("rawtypes")
	private final UserPersistenceMapper userMapper;
	private final CopyPersistenceMapper copyMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public CheckOut mapToDomain(CheckOutEntity checkOutEntity) {
		
		CheckOutEntityId checkOutId = checkOutEntity.getCheckOutId();
		LocalDate checkOutDate = checkOutId.getCheckOutDate();
		UserEntity userEntity = checkOutId.getUser();
		LocalDate expectedCheckInDate = checkOutEntity.getExpectedCheckInDate();
		User user = userMapper.mapToDomain(userEntity);
		CheckOut checkOut = new CheckOut(user, checkOutDate);
		checkOut.setExpectedCheckInDate(expectedCheckInDate);
		CheckInEntity checkInEntity = checkOutEntity.getCheckIn();
		if(checkInEntity != null) {
			checkOut.checkIn(checkInEntity.getCheckInDate());
		}
		List<CopyEntity> copies = checkOutEntity.getCopies();
		copies.forEach(c -> checkOut.addCopy(copyMapper.mapToDomain(c)));
		return checkOut;
	}


	@SuppressWarnings("unchecked")
	@Override
	public CheckOutEntity mapToEntity(CheckOut checkOut) {
		LocalDate checkOutDate = checkOut.getCheckOutDate();
		LocalDate expectedCheckInDate = checkOut.getExpectedCheckInDate();
		User user = checkOut.getUser();
		UserEntity userEntity = userMapper.mapToEntity(user);
		CheckOutEntity.CheckOutEntityId checkOutEntityId = new CheckOutEntityId(userEntity, checkOutDate);
		CheckOutEntity checkOutEntity = new CheckOutEntity(checkOutEntityId);
		checkOutEntity.setExpectedCheckInDate(expectedCheckInDate);
		CheckIn checkIn = checkOut.getCheckIn();
		if(checkIn != null) {
			LocalDate checkInDate = checkIn.getCheckInDate();
			checkOutEntity.checkIn(checkInDate);
		}
		List<Copy> copies = checkOut.getCopies();
		copies.forEach(c -> checkOutEntity.addCopy(copyMapper.mapToEntity(c)));
		return checkOutEntity;
	}

}
