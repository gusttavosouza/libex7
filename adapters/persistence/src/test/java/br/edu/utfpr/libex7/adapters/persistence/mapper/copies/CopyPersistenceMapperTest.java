package br.edu.utfpr.libex7.adapters.persistence.mapper.copies;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.StatusCopyDataEnum;
import br.edu.utfpr.libex7.adapters.persistence.mapper.authors.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;

public class CopyPersistenceMapperTest {

	private CategoryPersistenceMapper categoryMapper;
	private AuthorPersistenceMapper authorMapper;
	private BookPersistenceMapper bookPersistenceMapper;
    private CopyPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
    	this.categoryMapper = new CategoryPersistenceMapper();
    	this.authorMapper = new AuthorPersistenceMapper();
    	this.bookPersistenceMapper = new BookPersistenceMapper(categoryMapper,authorMapper );
        this.mapper = new CopyPersistenceMapper(bookPersistenceMapper);
    }


    @Test
    @DisplayName("Given Copy Domain When Map Then Return Copy Entity")
    public void givenBookDomainWhenMapThenReturnBookEntity(){

        Copy copy = new Copy(1L);
        copy.setAcquisitionDate(LocalDate.now());
        
        Book book = new Book(1L);
        book.setCategory(new Category(1L));
        copy.setBook(book);
        
        copy.setStatus(StatusCopyEnum.AVAILABLE);

        CopyEntity copyEntity = mapper.mapToEntity(copy);

        assertThat(copyEntity.getId()).isEqualTo(copy.getId());
        assertThat(copyEntity.getAcquisitionDate()).isEqualTo(copy.getAcquisitionDate());
        assertThat(copyEntity.getBook().getId()).isEqualTo(copy.getBook().getId());
        assertThat(copyEntity.getStatus().getStatus()).isEqualTo(copy.getStatus());
    }

    @Test
    @DisplayName("Given Copy Entity When Map Then Return Copy Domain")
    public void givenBookEntityWhenMapThenReturnBookDomain(){
        CopyEntity copyEntity = new CopyEntity(1L);
        copyEntity.setAcquisitionDate(LocalDate.now());
        BookEntity bookEntity = new BookEntity(1L);
        bookEntity.setCategory(new CategoryEntity(1L));
        copyEntity.setBook(bookEntity);
        copyEntity.setStatus(StatusCopyDataEnum.AVAILABLE);

        Copy copy = mapper.mapToDomain(copyEntity);

        assertThat(copy.getId()).isEqualTo(copyEntity.getId());
        assertThat(copy.getAcquisitionDate()).isEqualTo(copyEntity.getAcquisitionDate());
        assertThat(copy.getBook().getId()).isEqualTo(copyEntity.getBook().getId());
        assertThat(copy.getStatus()).isEqualTo(copyEntity.getStatus().getStatus());
    }
}
