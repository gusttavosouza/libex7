package br.edu.utfpr.libex7.adapters.persistence.service.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.UserRepository;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class UserPersistenceServiceTest {

    private UserRepository repository;
    private UserPersistenceService service;


    @BeforeEach
    public void setup(){
        this.repository = mock(UserRepository.class);
        this.service = new UserPersistenceService(repository);
    }

    @Test
    @DisplayName("Given New User When Save Then Return Saved User")
    public void givenNewUserWhenSaveThenReturnSavedUser(){
        UserEntity user = new EmployeeEntity();
        user.setName("Foo");
        when(repository.save(any(UserEntity.class))).thenReturn(new EmployeeEntity());
        UserEntity savedUser = service.save(user);
        assertThat(savedUser).isNotNull();
    }

    @Test
    @DisplayName("Given User Id When Exists Then Return User")
    public void givenUserIdWhenExistsThenReturnUser(){
        User user = new Employee();
        user.setName("Foo");
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(new EmployeeEntity()));
        Optional<UserEntity> optionalUser = service.findById(1L);
        assertTrue(optionalUser.isPresent());
    }

    @Test
    @DisplayName("Given User Id When Not Exists Then Return User")
    public void givenUserIdWhenNotExistsThenReturnUser(){
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<UserEntity> optionalUser = service.findById(1L);
        assertFalse(optionalUser.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return User List")
    public void givenFindAllMethodWhenIsCalledThenReturnUserList(){
        User user = new Employee();
        user.setName("Foo");
        when(repository.findAll()).thenReturn(Arrays.asList(new EmployeeEntity()));
        List<UserEntity> authors = service.findAll();
        assertFalse(authors.isEmpty());
    }

    @Test
    @DisplayName("Given Existing User When Remove Then Do Nothing")
    public void givenExistingUserWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(repository, times(1)).remove(anyLong());
    }
}
