package br.edu.utfpr.libex7.adapters.persistence.mapper.phones;


import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PhonePersistenceMapperTest {

    private PhonePersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new PhonePersistenceMapper();
    }


    @Test
    @DisplayName("Given Phone Domain When Map Then Return Phone Entity")
    public void givenPhoneDomainWhenMapThenReturnPhoneEntity(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 12345L;
        Employee user = new Employee(id, name, dob,employeeNumber);
        Phone phone = new Phone();
        user.addPhone(phone);

        PhoneEntity phoneEntity = mapper.mapToEntity(phone);


        assertThat(phoneEntity.getNumber()).isEqualTo(phone.getNumber());
        assertThat(phoneEntity.getUser()).isNull();
    }

    @Test
    @DisplayName("Given Phone Entity When Map Then Return Phone Domain")
    public void givenPhoneEntityWhenMapThenReturnPhoneDomain(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        PhoneEntity phoneEntity = new PhoneEntity();
        Long employeeNumber = 12345L;
        EmployeeEntity user = new EmployeeEntity(id, name, dob,employeeNumber );
        user.addPhone(phoneEntity);

        Phone phone = mapper.mapToDomain(phoneEntity);

        assertThat(phone.getNumber()).isEqualTo(phoneEntity.getNumber());
        assertThat(phone.getUser()).isNull();
    }
}
