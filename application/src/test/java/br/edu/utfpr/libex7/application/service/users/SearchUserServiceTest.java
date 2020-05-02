package br.edu.utfpr.libex7.application.service.users;


import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.out.users.SearchUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchUserServiceTest {

    private SearchUserPort port;
    private SearchUserService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SearchUserPort.class);
        this.service = new SearchUserService(port);
    }

    @Test
    @DisplayName("Given User Id When Search Then Return User")
    public void givenUserIdWhenSearchThenReturnUser(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Phone phone = new Phone();
        Long studentNumber = 12345L;
        Student user = new Student(id, name, dob,studentNumber );
        user.addPhone(phone);

        when(port.findById(anyLong())).thenReturn(Optional.ofNullable(user));

        Optional<User> optionalUser = service.findById(id);
        assertTrue(optionalUser.isPresent());
        Student foundedUser = (Student) optionalUser.get();
        assertThat(foundedUser.getId()).isEqualTo(user.getId());
        assertThat(foundedUser.getName()).isEqualTo(user.getName());
        assertThat(foundedUser.getDob()).isEqualTo(user.getDob());
        assertThat(foundedUser.getPhones()).isEqualTo(user.getPhones());
        assertThat(foundedUser.getStudentNumber()).isEqualTo(user.getStudentNumber());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then User List")
    public void givenFindAllMethodWhenIsCalledThenReturnUserList(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);

        Long studentNumber = 12345L;
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setDob(dob);
        student.setStudentNumber(studentNumber);
        Phone phone = new Phone(student, 121233L);
        student.addPhone(phone);

        Employee employee = new Employee(1L, "Bar", dob, 1213123L);

        when(port.findAll()).thenReturn(Arrays.asList(student, employee));

        List<User> users = service.findAll();
        assertFalse(users.isEmpty());
    }
}
