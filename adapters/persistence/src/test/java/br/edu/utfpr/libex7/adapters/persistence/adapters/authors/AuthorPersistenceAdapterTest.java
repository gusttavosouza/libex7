package br.edu.utfpr.libex7.adapters.persistence.adapters.authors;

import br.edu.utfpr.libex7.adapters.persistence.adapters.author.AuthorPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.authors.AuthorPersistenceService;
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

public class AuthorPersistenceAdapterTest {

    private AuthorPersistenceService service;
    private AuthorPersistenceMapper mapper;
    private AuthorPersistenceAdapter adapter;

    @BeforeEach
    public void setup(){
        this.service = mock(AuthorPersistenceService.class);
        this.mapper = new AuthorPersistenceMapper();
        this.adapter = new AuthorPersistenceAdapter(service,mapper);
    }

    @Test
    @DisplayName("Given New Author When Save Then Return Saved Author")
    public void givenNewAuthorWhenSaveThenReturnSavedAuthor(){
        Author author = new Author();
        author.setName("Foo");
        when(service.save(any(AuthorEntity.class))).thenReturn(new AuthorEntity());
        Author savedAuthor = adapter.save(author);
        assertThat(savedAuthor).isNotNull();
    }

    @Test
    @DisplayName("Given Author Id When Exists Then Return Author")
    public void givenAuthorIdWhenExistsThenReturnAuthor(){
        Author author = new Author();
        author.setName("Foo");
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(new AuthorEntity()));
        Optional<Author> optionalAuthor = adapter.findById(1L);
        assertTrue(optionalAuthor.isPresent());
    }

    @Test
    @DisplayName("Given Author Id When Not Exists Then Return Author")
    public void givenAuthorIdWhenNotExistsThenReturnAuthor(){
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<Author> optionalAuthor = adapter.findById(1L);
        assertFalse(optionalAuthor.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return Author List")
    public void givenFindAllMethodWhenIsCalledThenReturnAuthorList(){
        Author author = new Author();
        author.setName("Foo");
        when(service.findAll()).thenReturn(Arrays.asList(new AuthorEntity()));
        List<Author> authors = adapter.findAll();
        assertFalse(authors.isEmpty());
    }

    @Test
    @DisplayName("Given Existing Author When Remove Then Do Nothing")
    public void givenExistingAuthorWhenRemoveThenDoNothing(){
        adapter.remove(1L);
        verify(service, times(1)).remove(anyLong());
    }
}
