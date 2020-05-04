package br.edu.utfpr.libex7.adapters.persistence.mapper.books;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;

public class BookPersistenceMapperTest {

	private CategoryPersistenceMapper categoryMapper;
	private AuthorPersistenceMapper authorMapper;
    private BookPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
    	this.categoryMapper = new CategoryPersistenceMapper();
    	this.authorMapper = new AuthorPersistenceMapper();
        this.mapper = new BookPersistenceMapper(categoryMapper, authorMapper);
    }


    @Test
    @DisplayName("Given Book Domain When Map Then Return Book Entity")
    public void givenBookDomainWhenMapThenReturnBookEntity(){

        Book book = new Book(1L);
        book.setTitle("Foo");
        book.setCategory(new Category(1L));
        book.setYear(1994);

        BookEntity bookEntity = mapper.mapToEntity(book);

        assertThat(bookEntity.getId()).isEqualTo(book.getId());
        assertThat(bookEntity.getTitle()).isEqualTo(book.getTitle());
        assertThat(bookEntity.getYear()).isEqualTo(book.getYear());
        assertThat(bookEntity.getCategory().getDescription()).isEqualTo(book.getCategory().getDescription());
        assertThat(bookEntity.getAuthors().size()).isEqualTo(book.getAuthors().size());
    }

    @Test
    @DisplayName("Given Book Entity When Map Then Return Book Domain")
    public void givenBookEntityWhenMapThenReturnBookDomain(){
        BookEntity bookEntity = new BookEntity(1L);
        bookEntity.setTitle("Foo");
        bookEntity.setCategory(new CategoryEntity(1L));
        bookEntity.setYear(1994);

        Book book = mapper.mapToDomain(bookEntity);

        assertThat(book.getId()).isEqualTo(bookEntity.getId());
        assertThat(book.getTitle()).isEqualTo(bookEntity.getTitle());
        assertThat(book.getYear()).isEqualTo(bookEntity.getYear());
        assertThat(book.getCategory().getDescription()).isEqualTo(bookEntity.getCategory().getDescription());
        assertThat(book.getAuthors().size()).isEqualTo(bookEntity.getAuthors().size());
    }
}
