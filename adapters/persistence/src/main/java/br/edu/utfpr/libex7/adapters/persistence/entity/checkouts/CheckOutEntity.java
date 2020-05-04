package br.edu.utfpr.libex7.adapters.persistence.entity.checkouts;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import lombok.Getter;
import lombok.Setter;

public class CheckOutEntity {
	
	@Getter
	private UserEntity user;
	
	@Getter
	private LocalDate checkOutDate;
	
	@Getter
	@Setter
	private LocalDate expectedCheckInDate;
	
	@Getter
	@Setter
	private LocalDate checkInDate;
	
	private List<CopyEntity> copies = new LinkedList<>();
	
	public List<CopyEntity> getCopies() {
		return Collections.unmodifiableList(copies);
	}
	
	
	public CheckOutEntity(UserEntity user, LocalDate checkOutDate) {
		this.user = user;
		this.checkOutDate = checkOutDate;
	}
	
	

}
