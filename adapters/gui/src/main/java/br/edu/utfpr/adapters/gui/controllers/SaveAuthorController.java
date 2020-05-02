package br.edu.utfpr.adapters.gui.controllers;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SaveAuthorUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveAuthorController {

    private final SaveAuthorUseCase useCase;

    public Author save(Author author) {
        return useCase.save(author);
    }
}
