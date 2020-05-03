package br.edu.utfpr.libex7.application.service.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.out.authors.SearchAuthorPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SearchAuthorService implements SearchAuthorUseCase {

    private final SearchAuthorPort searchAuthorPort;

    @Override
    public Optional<Author> findById(Long id) {
        return searchAuthorPort.findById(id);
    }

    @Override
    public List<Author> findByName(String name) {
        return searchAuthorPort.findByName(name);
    }

    @Override
    public List<Author> findAll() {
        return searchAuthorPort.findAll();
    }
}
