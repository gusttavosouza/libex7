package br.edu.utfpr.libex7.application.ports.in.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;

public interface SaveAuthorUseCase {

    Author save(Author author);
}
