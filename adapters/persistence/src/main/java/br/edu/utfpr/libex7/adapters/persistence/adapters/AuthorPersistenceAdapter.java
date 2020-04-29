package br.edu.utfpr.libex7.adapters.persistence.adapters;

import br.edu.utfpr.libex7.adapters.persistence.entity.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.AuthorPersistenceService;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.out.SaveAuthorPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorPersistenceAdapter implements SaveAuthorPort {

    private final AuthorPersistenceService service;
    private final AuthorPersistenceMapper mapper;

    @Override
    public Author save(Author author) {
        AuthorEntity authorEntity = mapper.mapToEntity(author);
        service.save(authorEntity);
        return mapper.mapToDomain(authorEntity);
    }

}
