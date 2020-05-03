package br.edu.utfpr.libex7.application.domain.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends User{

    private Long studentNumber;

    public Student(Long id) {
        super(id);
    }
}
