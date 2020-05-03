package br.edu.utfpr.libex7.adapters.persistence.mapper.users;


import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.phones.PhonePersistenceMapper;
import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeePersistenceMapperTest {

    private EmployeePersistenceMapper mapper;
    private PhonePersistenceMapper phonePersistenceMapper;

    @BeforeEach
    public void setup(){
        this.phonePersistenceMapper = new PhonePersistenceMapper();
        this.mapper = new EmployeePersistenceMapper(phonePersistenceMapper);
    }


    @Test
    @DisplayName("Given User Domain When Map Then Return User Entity")
    public void givenUserDomainWhenMapThenReturnUserEntity(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Phone phone = new Phone();
        Long employeeNumber = 12345L;
        Employee user = new Employee(id, name, dob,employeeNumber);
        user.addPhone(phone);

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
        PhoneEntity phone = new PhoneEntity();
        Long employeeNumber = 12345L;
        EmployeeEntity userEntity = new EmployeeEntity(id, name, dob,employeeNumber );
        userEntity.addPhone(phone);

        Employee user = mapper.mapToDomain(userEntity);

        assertThat(user.getId()).isEqualTo(userEntity.getId());
        assertThat(user.getName()).isEqualTo(userEntity.getName());
        assertThat(user.getDob()).isEqualTo(userEntity.getDob());
        assertThat(user.getPhones().size()).isEqualTo(userEntity.getPhones().size());
        assertThat(user.getEmployeeNumber()).isEqualTo(userEntity.getEmployeeNumber());
    }
}
