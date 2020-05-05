package br.edu.utfpr.libex7.adapters.persistence.mapper.checkouts;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.StudentPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.users.Student;

public class CheckOutPersistenceMapperTest {

	private StudentPersistenceMapper userMapper;
    private CheckOutPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
    	this.userMapper = new StudentPersistenceMapper();
        this.mapper = new CheckOutPersistenceMapper(userMapper);
    }


    @Test
    @DisplayName("Given CheckOut Domain When Map Then Return CheckOut Entity")
    public void givenCheckOutDomainWhenMapThenReturnCheckOutEntity(){

        Book book = new Book(1L);
        book.setTitle("Foo");
        book.setCategory(new Category(1L));
        book.setYear(1994);
        
        CheckOut checkOut = new CheckOut(new Student(1L), LocalDate.now());
        checkOut.checkIn(LocalDate.now());

        CheckOutEntity checkOutEntity = mapper.mapToEntity(checkOut);

        assertThat(checkOutEntity.getCheckIn().getCheckInDate()).isEqualTo(checkOut.getCheckIn().getCheckInDate());
        assertThat(checkOutEntity.getExpectedCheckInDate()).isEqualTo(checkOut.getExpectedCheckInDate());
        assertThat(checkOutEntity.getCopies().size()).isEqualTo(checkOut.getCopies().size());
    }

    @Test
    @DisplayName("Given CheckOut Entity When Map Then Return CheckOut Domain")
    public void givenCheckOutEntityWhenMapThenReturnCheckOutDomain(){
        BookEntity bookEntity = new BookEntity(1L);
        bookEntity.setTitle("Foo");
        bookEntity.setCategory(new CategoryEntity(1L));
        bookEntity.setYear(1994);

        CheckOutEntity.CheckOutEntityId checkOutEntityId = new   CheckOutEntity.CheckOutEntityId(new StudentEntity(1L), LocalDate.now());
        CheckOutEntity checkOutEntity = new CheckOutEntity(checkOutEntityId);
        checkOutEntity.checkIn(LocalDate.now());

        CheckOut checkOut = mapper.mapToDomain(checkOutEntity);
        

        assertThat(checkOut.getCheckIn().getCheckInDate()).isEqualTo(checkOutEntity.getCheckIn().getCheckInDate());
        assertThat(checkOut.getExpectedCheckInDate()).isEqualTo(checkOutEntity.getExpectedCheckInDate());
        assertThat(checkOut.getCopies().size()).isEqualTo(checkOutEntity.getCopies().size());
    }
}
