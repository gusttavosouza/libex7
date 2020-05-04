package br.edu.utfpr.libex7.application.ports.out.checkin;

import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;

public interface RegisterCheckInPort {
	CheckIn register (CheckIn checkIn);
}
