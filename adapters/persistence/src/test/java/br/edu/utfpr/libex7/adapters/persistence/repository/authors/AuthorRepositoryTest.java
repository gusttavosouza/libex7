package br.edu.utfpr.libex7.adapters.persistence.repository.authors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;

public class AuthorRepositoryTest {

    private AuthorRepository repository;
	private static EntityManagerFactory entityManagerFactory;
    
    @BeforeAll
    public static void setupAll(){
    	entityManagerFactory = Persistence.createEntityManagerFactory("libex7");
    }

    @BeforeEach
    public void setup(){
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.repository = new AuthorRepository(entityManager);
    }

    @Test
    @DisplayName("Given New Author When Save Then Return Saved Author")
    public void givenNewAuthorWhenSaveThenReturnSavedAuthor(){
        String name = "Foo";
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        AuthorEntity savedAuthor = this.repository.save(authorEntity);
        assertThat(savedAuthor.getId()).isNotNull();
    }


    @Test
    @DisplayName("Given Existing Author When Find By Id Then Return Author")
    public void givenExistingAuthorWhenFindByIdThenReturnAuthor(){
        String name = "Foo";
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        AuthorEntity savedAuthor = this.repository.save(authorEntity);

        Optional<AuthorEntity> optionalAuthorEntity = repository.findById(savedAuthor.getId());
        assertTrue(optionalAuthorEntity.isPresent());
    }

    @Test
    @DisplayName("Given Existing Author When Remove By Id Then Do Nothing")
    public void givenExistingAuthorWhenRemoveThenDoNothing(){
        String name = "Foo";
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        AuthorEntity savedAuthor = this.repository.save(authorEntity);
        repository.remove(savedAuthor.getId());
    }


    @Test
    @DisplayName("Given Existing Authors When Find All Then Return Author List")
    public void givenExistingAuthorsWhenFindAllThenReturnAuthorList(){
        String name = "Foo";
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        this.repository.save(authorEntity);

        List<AuthorEntity> authorEntities = repository.findAll();
        assertFalse(authorEntities.isEmpty());
    }
}
