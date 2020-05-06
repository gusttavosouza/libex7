package br.edu.utfpr.libex7.application.service.checkouts;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.ports.in.checkout.SearchCheckOutUseCase;
import br.edu.utfpr.libex7.application.ports.out.checkout.SearchCheckOutPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchCheckOutService implements SearchCheckOutUseCase{
	
	private final SearchCheckOutPort port;

	@Override
	public Optional<Book> findById(Long id) {
		return port.findById(id);
	}

	@Override
	public List<CheckOut> findByUserId(Long userId) {
		return port.findByUserId(userId);
	}

	@Override
	public List<CheckOut> findAll() {
		return port.findAll();
	}

}
