package br.edu.utfpr.libex7.application.ports.in.checkin;

import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;

public interface RegisterCheckInUseCase {
	
	CheckIn register (CheckIn checkIn);

}
