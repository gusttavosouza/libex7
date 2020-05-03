package br.edu.utfpr.libex7.application.ports.out.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;

import java.util.List;
import java.util.Optional;

public interface SearchAuthorPort {
    Optional<Author> findById(Long id);
    List<Author> findByName(String name);
    List<Author> findAll();
}
