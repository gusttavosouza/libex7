package br.edu.utfpr.libex7.application.service.checkouts;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.ports.in.checkout.SaveCheckOutUseCase;
import br.edu.utfpr.libex7.application.ports.out.checkout.SaveCheckOutPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveCheckOutService implements SaveCheckOutUseCase {
	
	private final SaveCheckOutPort port;

	@Override
	public CheckOut register(CheckOut checkout) {
		return port.save(checkout);
	}
	

}
