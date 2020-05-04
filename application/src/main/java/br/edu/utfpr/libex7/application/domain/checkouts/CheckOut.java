package br.edu.utfpr.libex7.application.domain.checkouts;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;
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
	@Setter
	private CheckIn checkIn;
	
	private List<Copy> copies = new LinkedList<>();
	
	public List<Copy> getCopies() {
		return Collections.unmodifiableList(copies);
	}
	
	
	public CheckOut(User user, LocalDate checkOutDate) {
		this.user = user;
		this.checkOutDate = checkOutDate;
	}
	
	

}
