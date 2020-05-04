package br.edu.utfpr.libex7.application.service.checkins;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;

import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.out.checkin.RegisterCheckInPort;
import br.edu.utfpr.libex7.application.service.checkins.RegisterCheckInService;

public class RegisterCheckInServiceTest {
	
	private RegisterCheckInService service;
	private RegisterCheckInPort port;
	
	@BeforeEach
	public void setup() {
		this.port = mock(RegisterCheckInPort.class);
		this.service = new RegisterCheckInService(port);
	}
	
	@Test
	@DisplayName("Given CheckIn When Register Then Return Saved CheckIn")
	public void givenCheckInWhenRegisterThenReturnSavedCheckIn() {
		User user = new Student(1L);
		CheckOut checkout = new CheckOut(user, LocalDate.now());
		CheckIn checkIn = new CheckIn(checkout, LocalDate.now());
		
		
		when(port.register(any(CheckIn.class))).thenReturn(checkIn);
		
		CheckIn savedCheckin = this.service.register(checkIn);
		assertThat(savedCheckin.getCheckout()).isEqualTo(checkIn.getCheckout());
		assertThat(savedCheckin.getCheckInDate()).isEqualTo(checkIn.getCheckInDate());
	}

}
