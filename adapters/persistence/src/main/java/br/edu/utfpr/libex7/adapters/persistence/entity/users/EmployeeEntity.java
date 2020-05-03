package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeEntity extends UserEntity {


    private Long employeeNumber;

    public EmployeeEntity(Long id) {
        super(id);
    }
}
