package br.edu.utfpr.libex7.application.service.books;


import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.out.books.SaveBookPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveBookServiceTest {

    private SaveBookPort port;
    private SaveBookService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SaveBookPort.class);
        this.service = new SaveBookService(port);
    }

    @Test
    @DisplayName("Given Book When Save Then Return Saved Author")
    public void givenBookWhenSaveThenReturnSavedAuthor(){

        Long id = 1L;
        Book book = new Book(id);
        String title = "Foo";
        Integer year = 1994;
        Category category = new Category(1L);

        book.setTitle(title);
        book.setYear(year);
        book.setCategory(category);
        Author author = new Author(1L);
        book.addAuthor(author);

        when(port.save(any(Book.class))).thenReturn(book);

        Book savedBook = service.save(book);
        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isEqualTo(id);
        assertThat(savedBook.getTitle()).isEqualTo(title);
        assertThat(savedBook.getYear()).isEqualTo(year);
        assertThat(savedBook.getCategory()).isEqualTo(category);
        assertFalse(savedBook.getAuthors().isEmpty());
    }
}
