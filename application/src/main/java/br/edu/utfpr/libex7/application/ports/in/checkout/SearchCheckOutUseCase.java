package br.edu.utfpr.libex7.application.ports.in.checkout;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;

public interface SearchCheckOutUseCase {
	Optional<CheckOut> findById(Long id);
    List<CheckOut> findByUserId(Long userId);
    List<CheckOut> findAll();
}
