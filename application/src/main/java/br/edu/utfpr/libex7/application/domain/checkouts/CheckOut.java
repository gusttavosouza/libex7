package br.edu.utfpr.libex7.application.domain.checkouts;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.Getter;
import lombok.Setter;

public class CheckOut {

	@Getter
	private User user;

	@Getter
	private LocalDate checkOutDate;

	@Getter
	@Setter
	private LocalDate expectedCheckInDate;

	@Getter
	private CheckIn checkIn;

	private List<Copy> copies = new LinkedList<>();
	
	public CheckOut(User user, LocalDate checkOutDate) {
		this.user = user;
		this.checkOutDate = checkOutDate;
	}

	public List<Copy> getCopies() {
		return Collections.unmodifiableList(copies);
	}
	
	public void checkIn(LocalDate checkInDate) {
		this.checkIn = new CheckIn(this, checkInDate);
	}

	

	public static class CheckIn {

		@Getter
		private CheckOut checkout;

		@Getter
		private LocalDate checkInDate;

		public CheckIn(CheckOut checkout, LocalDate checkInDate) {
			this.checkout = checkout;
			this.checkInDate = checkInDate;
		}

	}

}
