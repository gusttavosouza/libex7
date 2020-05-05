package br.edu.utfpr.libex7.application.ports.out.checkout;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;

public interface SearchCheckOutPort {
	Optional<Book> findById(Long id);
    List<CheckOut> findByUserId(Long userId);
    List<CheckOut> findAll();
}
