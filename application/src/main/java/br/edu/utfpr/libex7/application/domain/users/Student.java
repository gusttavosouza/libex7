package br.edu.utfpr.libex7.application.domain.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student extends User{

    private Long studentNumber;

    public Student(Long id) {
        super(id);
    }
}
