package br.edu.utfpr.libex7.adapters.persistence.service.books;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.books.BookRepository;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;

public class BookPersistenceServiceTest {

    private BookRepository repository;
    private BookPersistenceService service;


    @BeforeEach
    public void setup(){
        this.repository = mock(BookRepository.class);
        this.service = new BookPersistenceService(repository);
    }

    @Test
    @DisplayName("Given New Book When Save Then Return Saved Book")
    public void givenNewBookWhenSaveThenReturnSavedBook(){
        BookEntity book = new BookEntity(1L);
        book.setTitle("Foo");
        book.setCategory(new CategoryEntity(1L));
        book.setYear(1994);
        
        when(repository.save(any(BookEntity.class))).thenReturn(new BookEntity(1L));
        BookEntity savedBook = service.save(book);
        assertThat(savedBook).isNotNull();
    }

    @Test
    @DisplayName("Given Book Id When Exists Then Return Book")
    public void givenBookIdWhenExistsThenReturnBook(){
        Book book = new Book(1L);
        book.setTitle("Foo");
        book.setCategory(new Category(1L));
        book.setYear(1994);
        
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(new BookEntity(1L)));
        Optional<BookEntity> optionalBook = service.findById(1L);
        assertTrue(optionalBook.isPresent());
    }

    @Test
    @DisplayName("Given Book Id When Not Exists Then Return Book")
    public void givenBookIdWhenNotExistsThenReturnBook(){
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<BookEntity> optionalBook = service.findById(1L);
        assertFalse(optionalBook.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return Book List")
    public void givenFindAllMethodWhenIsCalledThenReturnBookList(){
        Book book = new Book(1L);
        book.setTitle("Foo");
        book.setCategory(new Category(1L));
        book.setYear(1994);
        
        when(repository.findAll()).thenReturn(Arrays.asList(new BookEntity(1L)));
        List<BookEntity> books = service.findAll();
        assertFalse(books.isEmpty());
    }

    @Test
    @DisplayName("Given Existing Book When Remove Then Do Nothing")
    public void givenExistingBookWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(repository, times(1)).remove(anyLong());
    }
}
