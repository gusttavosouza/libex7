package br.edu.utfpr.libex7.adapters.persistence.mapper.authors;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.application.domain.authors.Author;

public class AuthorPersistenceMapper extends GenericMapper<Author, AuthorEntity> {


    @Override
    public Author mapToDomain(AuthorEntity authorEntity) {
        Long id = authorEntity.getId();
        String name = authorEntity.getName();
        Author author = new Author(id);
        author.setName(name);
        return author;
    }

    @Override
    public AuthorEntity mapToEntity(Author author) {
        Long id = author.getId();
        String name = author.getName();
        AuthorEntity authorEntity = new AuthorEntity(id);
        authorEntity.setName(name);
        return authorEntity;
    }
}
