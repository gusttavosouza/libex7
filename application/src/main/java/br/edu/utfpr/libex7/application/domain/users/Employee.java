package br.edu.utfpr.libex7.application.domain.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Employee extends User {

    public Employee(Long id, String name, LocalDate dob, Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    private Long employeeNumber;

}
