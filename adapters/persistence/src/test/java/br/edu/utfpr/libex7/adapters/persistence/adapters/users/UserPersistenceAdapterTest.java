package br.edu.utfpr.libex7.adapters.persistence.adapters.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.phones.PhonePersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.EmployeePersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.UserPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.users.UserPersistenceService;
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

public class UserPersistenceAdapterTest {

    private UserPersistenceService service;
    private PhonePersistenceMapper phonePersistenceMapper;
    private UserPersistenceMapper mapper;
    private UserPersistenceAdapter adapter;

    @BeforeEach
    public void setup(){
        this.service = mock(UserPersistenceService.class);
        this.phonePersistenceMapper = new PhonePersistenceMapper();
        this.mapper = new EmployeePersistenceMapper(phonePersistenceMapper);
        this.adapter = new UserPersistenceAdapter(service,mapper);
    }

    @Test
    @DisplayName("Given New User When Save Then Return Saved User")
    public void givenNewUserWhenSaveThenReturnSavedUser(){
        User user = new Employee();
        user.setName("Foo");
        when(service.save(any(UserEntity.class))).thenReturn(new EmployeeEntity());
        User savedUser = adapter.save(user);
        assertThat(savedUser).isNotNull();
    }

    @Test
    @DisplayName("Given User Id When Exists Then Return User")
    public void givenUserIdWhenExistsThenReturnUser(){
        User user = new Employee();
        user.setName("Foo");
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(new EmployeeEntity()));
        Optional<User> optionalUser = adapter.findById(1L);
        assertTrue(optionalUser.isPresent());
    }

    @Test
    @DisplayName("Given User Id When Not Exists Then Return User")
    public void givenUserIdWhenNotExistsThenReturnUser(){
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<User> optionalUser = adapter.findById(1L);
        assertFalse(optionalUser.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return User List")
    public void givenFindAllMethodWhenIsCalledThenReturnUserList(){
        User user = new Employee();
        user.setName("Foo");
        when(service.findAll()).thenReturn(Arrays.asList(new EmployeeEntity()));
        List<User> authors = adapter.findAll();
        assertFalse(authors.isEmpty());
    }

    @Test
    @DisplayName("Given Existing User When Remove Then Do Nothing")
    public void givenExistingUserWhenRemoveThenDoNothing(){
        adapter.remove(1L);
        verify(service, times(1)).remove(anyLong());
    }
}
