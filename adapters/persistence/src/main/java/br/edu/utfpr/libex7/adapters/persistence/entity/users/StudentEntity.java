package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentEntity extends UserEntity{


    private Long studentNumber;

    public StudentEntity(Long id) {
        super(id);
    }
}
