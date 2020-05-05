package br.edu.utfpr.libex7.adapters.persistence.service.checkouts;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckOutEntityId;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.checkouts.CheckOutRepository;

public class CheckOutPersistenceServiceTest {

    private CheckOutRepository repository;
    private CheckOutPersistenceService service;


    @BeforeEach
    public void setup(){
        this.repository = mock(CheckOutRepository.class);
        this.service = new CheckOutPersistenceService(repository);
    }

    @Test
    @DisplayName("Given New CheckOut When Save Then Return Saved CheckOut")
    public void givenNewCheckOutWhenSaveThenReturnSavedCheckOut(){
    	CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(new StudentEntity(1L), LocalDate.now());
        CheckOutEntity checkOut = new CheckOutEntity(checkOutId);
      
     
        when(repository.save(any(CheckOutEntity.class))).thenReturn(new CheckOutEntity(checkOutId));
        CheckOutEntity savedCheckOut = service.save(checkOut);
        assertThat(savedCheckOut).isNotNull();
    }

    @Test
    @DisplayName("Given CheckOut Id When Exists Then Return CheckOut")
    public void givenCheckOutIdWhenExistsThenReturnCheckOut(){
    	CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(new StudentEntity(1L), LocalDate.now());
        
        when(repository.findById(any(CheckOutEntityId.class))).thenReturn(Optional.ofNullable(new CheckOutEntity(checkOutId)));
        Optional<CheckOutEntity> optionalCheckOut = service.findById(checkOutId);
        assertTrue(optionalCheckOut.isPresent());
    }

    @Test
    @DisplayName("Given CheckOut Id When Not Exists Then Return CheckOut")
    public void givenCheckOutIdWhenNotExistsThenReturnCheckOut(){
        when(repository.findById(any(CheckOutEntityId.class))).thenReturn(Optional.ofNullable(null));
        
        CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(new StudentEntity(1L), LocalDate.now());
        Optional<CheckOutEntity> optionalCheckOut = service.findById(checkOutId);
        assertFalse(optionalCheckOut.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return CheckOut List")
    public void givenFindAllMethodWhenIsCalledThenReturnCheckOutList(){
    	CheckOutEntity.CheckOutEntityId checkOutId = new CheckOutEntity.CheckOutEntityId(new StudentEntity(1L), LocalDate.now());
        CheckOutEntity checkOut = new CheckOutEntity(checkOutId);
        
        
        when(repository.findAll()).thenReturn(Arrays.asList(checkOut));
        List<CheckOutEntity> checkOuts = service.findAll();
        assertFalse(checkOuts.isEmpty());
    }

  
}
