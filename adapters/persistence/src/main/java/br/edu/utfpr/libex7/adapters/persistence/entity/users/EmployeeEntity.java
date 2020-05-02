package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity extends UserEntity {

    private Long employeeNumber;

}
