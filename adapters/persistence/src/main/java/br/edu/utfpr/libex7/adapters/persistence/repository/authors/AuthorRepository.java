package br.edu.utfpr.libex7.adapters.persistence.repository.authors;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;
import br.edu.utfpr.libex7.application.domain.authors.Author;

public class AuthorRepository extends GenericRepository<AuthorEntity, Long> {

    public AuthorRepository(EntityManager em) {
        super(em);
    }

	public List<Author> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
