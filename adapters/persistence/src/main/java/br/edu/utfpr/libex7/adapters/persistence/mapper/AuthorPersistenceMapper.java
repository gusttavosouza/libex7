package br.edu.utfpr.libex7.adapters.persistence.mapper;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.application.domain.authors.Author;

public class AuthorPersistenceMapper implements AbstractMapper<Author, AuthorEntity> {


    @Override
    public Author mapToDomain(AuthorEntity authorEntity) {
        Long id = authorEntity.getId();
        String name = authorEntity.getName();
        return new Author(id,name);
    }

    @Override
    public AuthorEntity mapToEntity(Author author) {
        Long id = author.getId();
        String name = author.getName();
        return new AuthorEntity(id, name);
    }
}
