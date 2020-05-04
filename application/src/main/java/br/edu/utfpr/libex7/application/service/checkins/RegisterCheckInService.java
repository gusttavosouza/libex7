package br.edu.utfpr.libex7.application.service.checkins;

import br.edu.utfpr.libex7.application.domain.checkins.CheckIn;
import br.edu.utfpr.libex7.application.ports.in.checkin.RegisterCheckInUseCase;
import br.edu.utfpr.libex7.application.ports.out.checkin.RegisterCheckInPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterCheckInService implements RegisterCheckInUseCase {
	
	private final RegisterCheckInPort port;

	@Override
	public CheckIn register(CheckIn checkIn) {
		return port.register(checkIn);
	}
	


}
