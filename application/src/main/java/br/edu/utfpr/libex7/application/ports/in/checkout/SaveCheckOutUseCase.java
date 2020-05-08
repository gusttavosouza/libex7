package br.edu.utfpr.libex7.application.ports.in.checkout;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;

public interface SaveCheckOutUseCase {
	
	CheckOut save (CheckOut checkout);

}
