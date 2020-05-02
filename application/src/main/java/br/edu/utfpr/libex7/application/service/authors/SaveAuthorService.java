package br.edu.utfpr.libex7.application.service.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SaveAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.out.authors.SaveAuthorPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveAuthorService implements SaveAuthorUseCase {

    private final SaveAuthorPort saveAuthorPort;

    @Override
    public Author save(Author author) {
        return saveAuthorPort.save(author);
    }
}
