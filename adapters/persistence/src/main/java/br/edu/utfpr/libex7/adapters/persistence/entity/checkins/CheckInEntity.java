package br.edu.utfpr.libex7.adapters.persistence.entity.checkins;

import java.time.LocalDate;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import lombok.Getter;

public class CheckInEntity {
	
	@Getter
	private CheckOutEntity checkout;
	
	@Getter
	private LocalDate checkInDate;

	public CheckInEntity(CheckOutEntity checkout, LocalDate date) {
		this.checkout = checkout;
		this.checkInDate = date;
	}
	
	


	

}
