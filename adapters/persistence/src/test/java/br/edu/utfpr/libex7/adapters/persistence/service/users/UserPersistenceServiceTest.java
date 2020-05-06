package br.edu.utfpr.libex7.adapters.persistence.service.users;

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

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.UserRepository;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.User;

public class UserPersistenceServiceTest {

    private UserRepository<EmployeeEntity> repository;
    private UserPersistenceService<EmployeeEntity> service;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@BeforeEach
    public void setup(){
        this.repository = mock(UserRepository.class);
        this.service = new UserPersistenceService(repository);
    }

    @Test
    @DisplayName("Given New User When Save Then Return Saved User")
    public void givenNewUserWhenSaveThenReturnSavedUser(){
    	EmployeeEntity user = new EmployeeEntity(1L);
        user.setName("Foo");
        when(repository.save(any(EmployeeEntity.class))).thenReturn(new EmployeeEntity(1L));
        EmployeeEntity savedUser = service.save(user);
        assertThat(savedUser).isNotNull();
    }

    @Test
    @DisplayName("Given User Id When Exists Then Return User")
    public void givenUserIdWhenExistsThenReturnUser(){
        User user = new Employee(1L);
        user.setName("Foo");
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(new EmployeeEntity(1L)));
        Optional<EmployeeEntity> optionalUser = service.findById(1L);
        assertTrue(optionalUser.isPresent());
    }

    @Test
    @DisplayName("Given User Id When Not Exists Then Return User")
    public void givenUserIdWhenNotExistsThenReturnUser(){
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<EmployeeEntity> optionalUser = service.findById(1L);
        assertFalse(optionalUser.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return User List")
    public void givenFindAllMethodWhenIsCalledThenReturnUserList(){
        User user = new Employee(1L);
        user.setName("Foo");
        when(repository.findAll()).thenReturn(Arrays.asList(new EmployeeEntity(1L)));
        List<EmployeeEntity> authors = service.findAll();
        assertFalse(authors.isEmpty());
    }

    @Test
    @DisplayName("Given Existing User When Remove Then Do Nothing")
    public void givenExistingUserWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(repository, times(1)).remove(anyLong());
    }
}
