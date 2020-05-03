package br.edu.utfpr.libex7.adapters.persistence.mapper.users;


import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeePersistenceMapperTest {

    private EmployeePersistenceMapper mapper;


    @BeforeEach
    public void setup(){
        this.mapper = new EmployeePersistenceMapper();
    }


    @Test
    @DisplayName("Given User Domain When Map Then Return User Entity")
    public void givenUserDomainWhenMapThenReturnUserEntity(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 12345L;
        Employee user = new Employee(id);
        user.setName(name);
        user.setDob(dob);
        user.setEmployeeNumber(employeeNumber);
        user.addPhone(9898989L);

        EmployeeEntity userEntity =  mapper.mapToEntity(user);


        assertThat(userEntity.getId()).isEqualTo(user.getId());
        assertThat(userEntity.getName()).isEqualTo(user.getName());
        assertThat(userEntity.getDob()).isEqualTo(user.getDob());
        assertThat(userEntity.getPhones().size()).isEqualTo(user.getPhones().size());
        assertThat(userEntity.getEmployeeNumber()).isEqualTo(user.getEmployeeNumber());
    }

    @Test
    @DisplayName("Given User Entity When Map Then Return User Domain")
    public void givenUserEntityWhenMapThenReturnUserDomain(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 12345L;
        EmployeeEntity userEntity = new EmployeeEntity(id);
        userEntity.setName(name);
        userEntity.setDob(dob);
        userEntity.setEmployeeNumber(employeeNumber);
        userEntity.addPhone(9898989L);;

        Employee user = mapper.mapToDomain(userEntity);

        assertThat(user.getId()).isEqualTo(userEntity.getId());
        assertThat(user.getName()).isEqualTo(userEntity.getName());
        assertThat(user.getDob()).isEqualTo(userEntity.getDob());
        assertThat(user.getPhones().size()).isEqualTo(userEntity.getPhones().size());
        assertThat(user.getEmployeeNumber()).isEqualTo(userEntity.getEmployeeNumber());
    }
}
