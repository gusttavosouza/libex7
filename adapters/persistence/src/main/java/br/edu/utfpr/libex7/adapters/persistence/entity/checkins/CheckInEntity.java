package br.edu.utfpr.libex7.adapters.persistence.entity.checkins;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import lombok.Getter;

public class CheckInEntity {
	
	@Id
	@Getter
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "checkIn", optional = false)
	@Column(name = "DATA_DEVOLUCAO")
	private CheckOutEntity checkout;
	
	@Getter
	@Column(name = "DATA_DEVOLUCAO")
	private LocalDate checkInDate;

	public CheckInEntity(CheckOutEntity checkout, LocalDate date) {
		this.checkout = checkout;
		this.checkInDate = date;
	}
	
	


	

}
