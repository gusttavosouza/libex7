package br.edu.utfpr.libex7.adapters.persistence.service;

import br.edu.utfpr.libex7.adapters.persistence.entity.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorPersistenceService  implements IAuthorPersistenceService{

    private final AuthorRepository authorRepository;

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
