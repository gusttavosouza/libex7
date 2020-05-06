package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;

public class UserRepositoryTest {

    private static EntityManagerFactory entityManagerFactory;
	private EmployeeRepository repository;
    
    @BeforeAll
    public static void setupAll(){
    	entityManagerFactory = Persistence.createEntityManagerFactory("libex7");
    }

    @BeforeEach
    public void setup(){
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.repository = new EmployeeRepository(entityManager);
    }

    @Test
    @DisplayName("Given New User When Save Then Return Saved User")
    public void givenNewUserWhenSaveThenReturnSavedUser(){
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 1L;
        EmployeeEntity userEntity = new EmployeeEntity();
        userEntity.setName(name);
        userEntity.setDob(dob);
        userEntity.setEmployeeNumber(employeeNumber);
        userEntity.addPhone(99989898L);
        UserEntity savedUser = this.repository.save(userEntity);
        assertThat(savedUser.getId()).isNotNull();
    }


    @Test
    @DisplayName("Given Existing User When Find By Id Then Return User")
    public void givenExistingUserWhenFindByIdThenReturnUser(){
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 1L;
        EmployeeEntity userEntity = new EmployeeEntity();
        userEntity.setName(name);
        userEntity.setDob(dob);
        userEntity.setEmployeeNumber(employeeNumber);
        userEntity.addPhone(99989898L);
        UserEntity savedUser = this.repository.save(userEntity);

        Optional<EmployeeEntity> optionalUserEntity = repository.findById(savedUser.getId());
        assertTrue(optionalUserEntity.isPresent());
    }

    @Test
    @DisplayName("Given Existing User When Remove By Id Then Do Nothing")
    public void givenExistingUserWhenRemoveThenDoNothing(){
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 1L;
        EmployeeEntity userEntity = new EmployeeEntity();
        userEntity.setName(name);
        userEntity.setDob(dob);
        userEntity.setEmployeeNumber(employeeNumber);
        userEntity.addPhone(99989898L);
        UserEntity savedUser = this.repository.save(userEntity);
        repository.remove(savedUser.getId());
    }


    @Test
    @DisplayName("Given Existing Users When Find All Then Return User List")
    public void givenExistingUsersWhenFindAllThenReturnUserList(){
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 1L;
        EmployeeEntity userEntity = new EmployeeEntity();
        userEntity.setName(name);
        userEntity.setDob(dob);
        userEntity.setEmployeeNumber(employeeNumber);
        userEntity.addPhone(99989898L);
        this.repository.save(userEntity);

        List<EmployeeEntity> userEntities = repository.findAll();
        assertFalse(userEntities.isEmpty());
    }
}
