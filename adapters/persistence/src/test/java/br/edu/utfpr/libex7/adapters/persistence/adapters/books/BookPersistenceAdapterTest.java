package br.edu.utfpr.libex7.adapters.persistence.adapters.books;

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
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.books.BookPersistenceService;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;

public class BookPersistenceAdapterTest {

    private BookPersistenceService service;
    private CategoryPersistenceMapper categoryMapper;
	private AuthorPersistenceMapper authorMapper;
    private BookPersistenceMapper mapper;
    private BookPersistenceAdapter adapter;

    @BeforeEach
    public void setup(){
        this.service = mock(BookPersistenceService.class);
        this.categoryMapper = new CategoryPersistenceMapper();
        this.authorMapper = new AuthorPersistenceMapper();
        this.mapper = new BookPersistenceMapper(categoryMapper,authorMapper );
        this.adapter = new BookPersistenceAdapter(service,mapper);
    }

    @Test
    @DisplayName("Given New Book When Save Then Return Saved Book")
    public void givenNewBookWhenSaveThenReturnSavedBook(){
        Book book = new Book(1L);
        book.setTitle("Foo");
        book.setCategory(new Category(1L));
        book.setYear(1994);
        when(service.save(any(BookEntity.class))).thenReturn(new BookEntity(1L));
        Book savedBook = adapter.save(book);
        assertThat(savedBook).isNotNull();
    }

    @Test
    @DisplayName("Given Book Id When Exists Then Return Book")
    public void givenBookIdWhenExistsThenReturnBook(){
        Book book = new Book(1L);
        book.setTitle("Foo");
        book.setCategory(new Category(1L));
        book.setYear(1994);
        
        BookEntity bookEntity = new BookEntity(1L);
        bookEntity.setCategory(new CategoryEntity(1L));
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(bookEntity));
        Optional<Book> optionalBook = adapter.findById(1L);
        assertTrue(optionalBook.isPresent());
    }

    @Test
    @DisplayName("Given Book Id When Not Exists Then Return Book")
    public void givenBookIdWhenNotExistsThenReturnBook(){
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<Book> optionalBook = adapter.findById(1L);
        assertFalse(optionalBook.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return Book List")
    public void givenFindAllMethodWhenIsCalledThenReturnBookList(){
        Book book = new Book(1L);
        book.setTitle("Foo");
        book.setCategory(new Category(1L));
        book.setYear(1994);
        
        BookEntity bookEntity = new BookEntity(1L);
        bookEntity.setCategory(new CategoryEntity(1L));
        when(service.findAll()).thenReturn(Arrays.asList(bookEntity));
        List<Book> books = adapter.findAll();
        assertFalse(books.isEmpty());
    }

    @Test
    @DisplayName("Given Existing Book When Remove Then Do Nothing")
    public void givenExistingBookWhenRemoveThenDoNothing(){
        adapter.remove(1L);
        verify(service, times(1)).remove(anyLong());
    }
}
