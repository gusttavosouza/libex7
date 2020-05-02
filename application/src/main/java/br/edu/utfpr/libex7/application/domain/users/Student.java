package br.edu.utfpr.libex7.application.domain.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Student extends User{

    public Student(Long id, String name, LocalDate dob, Long studentNumber) {
        super(id, name, dob);
        this.studentNumber = studentNumber;
    }

    private Long studentNumber;

}
