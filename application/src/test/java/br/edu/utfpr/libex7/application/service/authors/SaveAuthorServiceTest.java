package br.edu.utfpr.libex7.application.service.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.out.authors.SaveAuthorPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveAuthorServiceTest {

    private SaveAuthorPort port;
    private SaveAuthorService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SaveAuthorPort.class);
        this.service = new SaveAuthorService(port);
    }

    @Test
    @DisplayName("Given Author When Save Then Return Saved Author")
    public void givenAuthorWhenSaveThenReturnSavedAuthor(){

        Long id = 1L;
        String name = "Foo";
        Author author = new Author(id, name);

        when(port.save(any(Author.class))).thenReturn(author);

        Author savedAuthor = service.save(author);
        assertThat(savedAuthor).isNotNull();
        assertThat(savedAuthor.getId()).isEqualTo(id);
        assertThat(savedAuthor.getName()).isEqualTo(name);
    }
}
