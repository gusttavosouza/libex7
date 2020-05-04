package br.edu.utfpr.libex7.application.service.checkouts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.out.checkout.RegisterCheckOutPort;
import br.edu.utfpr.libex7.application.service.checkouts.RegisterCheckOutService;

public class RegisterCheckOutServiceTest {
	
	private RegisterCheckOutService service;
	private RegisterCheckOutPort port;
	
	@BeforeEach
	public void setup() {
		this.port = mock(RegisterCheckOutPort.class);
		this.service = new RegisterCheckOutService(port);
	}
	
	@Test
	@DisplayName("Given CheckIn When Register Then Return Saved CheckIn")
	public void givenCheckInWhenRegisterThenReturnSavedCheckIn() {
		User user = new Student(1L);
		CheckOut checkout = new CheckOut(user, LocalDate.now());		
		checkout.setExpectedCheckInDate(LocalDate.now());
		CheckIn checkIn = new CheckIn(checkout, LocalDate.now());
		checkout.setCheckIn(checkIn);
		
		when(port.register(any(CheckOut.class))).thenReturn(checkout);
		
		CheckOut savedCheckout = this.service.register(checkout);
		assertThat(savedCheckout.getCheckIn()).isEqualTo(checkout.getCheckIn());
		assertThat(savedCheckout.getCheckOutDate()).isEqualTo(checkout.getCheckOutDate());
		assertThat(savedCheckout.getCopies().size()).isEqualTo(checkout.getCopies().size());
		assertThat(savedCheckout.getExpectedCheckInDate()).isEqualTo(checkout.getExpectedCheckInDate());
		assertThat(savedCheckout.getUser()).isEqualTo(checkout.getUser());
	}

}
