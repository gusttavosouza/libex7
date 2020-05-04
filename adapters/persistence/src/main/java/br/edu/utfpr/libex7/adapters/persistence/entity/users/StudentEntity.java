package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Table(name="ALUNO")
@Entity
public class StudentEntity extends UserEntity implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Column(name="REGISTRO_ALUNO")
    private Long studentNumber;

    public StudentEntity(Long id) {
        super(id);
    }
}
