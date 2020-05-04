package br.edu.utfpr.libex7.application.domain.checkins;

import java.time.LocalDate;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import lombok.Getter;

public class CheckIn {
	
	@Getter
	private CheckOut checkout;
	
	@Getter
	private LocalDate checkInDate;

	public CheckIn(CheckOut checkout, LocalDate checkInDate) {
		this.checkout = checkout;
		this.checkInDate = checkInDate;
	}
	
	


	

}
