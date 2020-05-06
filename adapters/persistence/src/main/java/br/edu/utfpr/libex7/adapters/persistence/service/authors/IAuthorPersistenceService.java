package br.edu.utfpr.libex7.adapters.persistence.service.authors;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;

public interface IAuthorPersistenceService {

    AuthorEntity save(AuthorEntity authorEntity);

    Optional<AuthorEntity> findById(Long id);

    List<AuthorEntity> findAll();

    void remove(Long id);

    List<AuthorEntity> findByName(String name);
}
