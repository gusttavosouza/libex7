package br.edu.utfpr.libex7.application.domain.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends User {


    private Long employeeNumber;

    public Employee(Long id) {
        super(id);
    }
}
