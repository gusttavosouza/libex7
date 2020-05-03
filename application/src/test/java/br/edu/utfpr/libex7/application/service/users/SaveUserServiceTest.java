package br.edu.utfpr.libex7.application.service.users;


import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.out.users.SaveUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveUserServiceTest {

    private SaveUserPort port;
    private SaveUserService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SaveUserPort.class);
        this.service = new SaveUserService(port);
    }

    @Test
    @DisplayName("Given User When Save Then Return Saved User")
    public void givenUserWhenSaveThenReturnSavedUser(){

        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long employeeNumber = 12345L;
        Employee user = new Employee(id);
        user.setName(name);
        user.setDob(dob);
        user.setEmployeeNumber(employeeNumber);
        user.addPhone(989898997L);

        when(port.save(any(User.class))).thenReturn(user);

        Employee savedUser = (Employee) service.save(user);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isEqualTo(user.getId());
        assertThat(savedUser.getName()).isEqualTo(user.getName());
        assertThat(savedUser.getDob()).isEqualTo(user.getDob());
        assertThat(savedUser.getEmployeeNumber()).isEqualTo(user.getEmployeeNumber());
        assertThat(savedUser.getPhones().size()).isEqualTo(user.getPhones().size());
        assertThat(savedUser.getPhones().get(0).getUser()).isEqualTo(user.getPhones().get(0).getUser());
        assertThat(savedUser.getPhones().get(0).getNumber()).isEqualTo(user.getPhones().get(0).getNumber());
    }
}
