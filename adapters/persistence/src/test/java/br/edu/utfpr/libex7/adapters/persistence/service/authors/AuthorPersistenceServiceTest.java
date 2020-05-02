package br.edu.utfpr.libex7.adapters.persistence.service.authors;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.authors.AuthorRepository;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class AuthorPersistenceServiceTest {

    private AuthorRepository repository;
    private AuthorPersistenceService service;


    @BeforeEach
    public void setup(){
        this.repository = mock(AuthorRepository.class);
        this.service = new AuthorPersistenceService(repository);
    }

    @Test
    @DisplayName("Given New Author When Save Then Return Saved Author")
    public void givenNewAuthorWhenSaveThenReturnSavedAuthor(){
        AuthorEntity author = new AuthorEntity();
        author.setName("Foo");
        when(repository.save(any(AuthorEntity.class))).thenReturn(new AuthorEntity());
        AuthorEntity savedAuthor = service.save(author);
        assertThat(savedAuthor).isNotNull();
    }

    @Test
    @DisplayName("Given Author Id When Exists Then Return Author")
    public void givenAuthorIdWhenExistsThenReturnAuthor(){
        AuthorEntity author = new AuthorEntity();
        author.setName("Foo");
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(new AuthorEntity()));
        Optional<AuthorEntity> optionalAuthor = service.findById(1L);
        assertTrue(optionalAuthor.isPresent());
    }

    @Test
    @DisplayName("Given Author Id When Not Exists Then Return Author")
    public void givenAuthorIdWhenNotExistsThenReturnAuthor(){
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<AuthorEntity> optionalAuthor = service.findById(1L);
        assertFalse(optionalAuthor.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return Author List")
    public void givenFindAllMethodWhenIsCalledThenReturnAuthorList(){
        Author author = new Author();
        author.setName("Foo");
        when(repository.findAll()).thenReturn(Arrays.asList(new AuthorEntity()));
        List<AuthorEntity> authors = service.findAll();
        assertFalse(authors.isEmpty());
    }

    @Test
    @DisplayName("Given Existing Author When Remove Then Do Nothing")
    public void givenExistingAuthorWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(repository, times(1)).remove(anyLong());
    }
}
