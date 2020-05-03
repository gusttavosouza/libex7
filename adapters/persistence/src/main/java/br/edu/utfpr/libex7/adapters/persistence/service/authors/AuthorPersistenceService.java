package br.edu.utfpr.libex7.adapters.persistence.service.authors;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.authors.AuthorRepository;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthorPersistenceService  implements IAuthorPersistenceService{

    private final AuthorRepository authorRepository;

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        authorRepository.remove(id);
    }

    @Override
    public List<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }
}
