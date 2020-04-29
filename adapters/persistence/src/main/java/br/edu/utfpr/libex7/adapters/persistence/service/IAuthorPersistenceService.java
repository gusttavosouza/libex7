package br.edu.utfpr.libex7.adapters.persistence.service;

import br.edu.utfpr.libex7.adapters.persistence.entity.AuthorEntity;

public interface IAuthorPersistenceService {

    AuthorEntity save(AuthorEntity authorEntity);

}
