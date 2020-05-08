package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Table(name="SERVIDOR")
@Entity
@SelectBeforeUpdate(false)
@DynamicInsert(false)
@DynamicUpdate(false)
public class EmployeeEntity extends UserEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Column(name="MATRICULA_SERVIDOR")
    private Long employeeNumber;

    public EmployeeEntity(Long id) {
        super(id);
    }
}
