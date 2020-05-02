package br.edu.utfpr.libex7.application.service.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.out.authors.SearchAuthorPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchAuthorServiceTest {

    private SearchAuthorPort port;
    private SearchAuthorService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SearchAuthorPort.class);
        this.service = new SearchAuthorService(port);
    }

    @Test
    @DisplayName("Given Author Id When Search Then Return Author")
    public void givenAuthorIdWhenSearchThenReturnAuthor(){
        Author author = new Author(1L, "Foo");

        when(port.findById(anyLong())).thenReturn(Optional.ofNullable(author));

        Optional<Author> optionalAuthor = service.findById(1L);
        assertTrue(optionalAuthor.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Author List")
    public void givenFindAllMethodWhenIsCalledThenReturnAuthorList(){
        Long id = 1L;
        String name = "Foo";
        Author author = new Author();
        author.setId(id);
        author.setName(name);

        when(port.findAll()).thenReturn(Arrays.asList(author));

        List<Author> authors = service.findAll();
        assertFalse(authors.isEmpty());
    }
}
