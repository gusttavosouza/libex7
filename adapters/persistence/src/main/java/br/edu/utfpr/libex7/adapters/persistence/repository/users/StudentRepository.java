package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;

public class StudentRepository extends UserRepository<StudentEntity> {

	public StudentRepository(EntityManager em) {
		super(em);
	}
	


}
