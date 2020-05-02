package br.edu.utfpr.libex7.application.ports.in.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;

import java.util.List;
import java.util.Optional;

public interface SearchAuthorUseCase {
    Optional<Author> findById(Long id);
    List<Author> findAll();
}
