package br.edu.utfpr.libex7.application.service.books;


import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.out.books.SearchBookPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchBookServiceTest {

    private SearchBookPort port;
    private SearchBookService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SearchBookPort.class);
        this.service = new SearchBookService(port);
    }

    @Test
    @DisplayName("Given Book Id When Search Then Return Book")
    public void givenBookIdWhenSearchThenReturnBook(){
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

        when(port.findById(anyLong())).thenReturn(Optional.ofNullable(book));

        Optional<Book> optionalBook = service.findById(1L);
        assertTrue(optionalBook.isPresent());
    }


    @Test
    @DisplayName("Given Book Title When Search Then Return Book List")
    public void givenBookTitleWhenSearchThenReturnBookList(){
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

        when(port.findByTitle(anyString())).thenReturn(Arrays.asList(book));

        List<Book> categories = service.findByTitle(title);
        assertFalse(categories.isEmpty());
    }

    @Test
    @DisplayName("Given Author Name Title When Search Then Return Book List")
    public void givenAuthorNameWhenSearchThenReturnBookList(){
        Long id = 1L;
        Book book = new Book(id);
        String title = "Foo";
        Integer year = 1994;
        Category category = new Category(1L);

        book.setTitle(title);
        book.setYear(year);
        book.setCategory(category);

        String name = "Bar";
        Author author = new Author(1L);
        author.setName(name);
        book.addAuthor(author);

        when(port.findByAuthorName(anyString())).thenReturn(Arrays.asList(book));

        List<Book> categories = service.findByAuthorName(name);
        assertFalse(categories.isEmpty());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Book List")
    public void givenFindAllMethodWhenIsCalledThenReturnBookList(){
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


        when(port.findAll()).thenReturn(Arrays.asList(book));

        List<Book> categories = service.findAll();
        assertFalse(categories.isEmpty());
    }
}
