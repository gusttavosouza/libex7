package br.edu.utfpr.libex7.adapters.persistence.mapper.users;


import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.application.domain.users.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentPersistenceMapperTest {

    private StudentPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new StudentPersistenceMapper();
    }


    @Test
    @DisplayName("Given User Domain When Map Then Return User Entity")
    public void givenUserDomainWhenMapThenReturnUserEntity(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long studentNumber = 12345L;
        Student user = new Student(id);
        user.setName(name);
        user.setDob(dob);
        user.setStudentNumber(studentNumber);
        user.addPhone(99988999L);

        StudentEntity userEntity =  (StudentEntity) mapper.mapToEntity(user);


        assertThat(userEntity.getId()).isEqualTo(user.getId());
        assertThat(userEntity.getName()).isEqualTo(user.getName());
        assertThat(userEntity.getDob()).isEqualTo(user.getDob());
        assertThat(userEntity.getPhones().size()).isEqualTo(user.getPhones().size());
        assertThat(userEntity.getStudentNumber()).isEqualTo(user.getStudentNumber());
    }

    @Test
    @DisplayName("Given User Entity When Map Then Return User Domain")
    public void givenUserEntityWhenMapThenReturnUserDomain(){
        Long id = 1L;
        String name = "Foo";
        LocalDate dob = LocalDate.of(1973, 05, 21);
        Long studentNumber = 12345L;
        StudentEntity userEntity = new StudentEntity(id);
        userEntity.setName(name);
        userEntity.setDob(dob);
        userEntity.setStudentNumber(studentNumber);
        userEntity.addPhone(99988999L);

        Student user = (Student) mapper.mapToDomain(userEntity);

        assertThat(user.getId()).isEqualTo(userEntity.getId());
        assertThat(user.getName()).isEqualTo(userEntity.getName());
        assertThat(user.getDob()).isEqualTo(userEntity.getDob());
        assertThat(user.getPhones().size()).isEqualTo(userEntity.getPhones().size());
        assertThat(user.getStudentNumber()).isEqualTo(userEntity.getStudentNumber());
    }
}
