package br.edu.utfpr.libex7.application.ports.out.checkout;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;

public interface RegisterCheckOutPort {
	
	CheckOut register (CheckOut checkIn);

}
