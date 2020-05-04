package br.edu.utfpr.libex7.application.service.checkouts;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.ports.in.checkout.RegisterCheckOutUseCase;
import br.edu.utfpr.libex7.application.ports.out.checkout.RegisterCheckOutPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterCheckOutService implements RegisterCheckOutUseCase {
	
	private final RegisterCheckOutPort port;

	@Override
	public CheckOut register(CheckOut checkout) {
		return port.register(checkout);
	}
	

}
