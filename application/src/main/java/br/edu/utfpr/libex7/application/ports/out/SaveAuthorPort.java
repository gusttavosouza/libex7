package br.edu.utfpr.libex7.application.ports.out;

import br.edu.utfpr.libex7.application.domain.authors.Author;

public interface SaveAuthorPort {
    Author save(Author author);
}
