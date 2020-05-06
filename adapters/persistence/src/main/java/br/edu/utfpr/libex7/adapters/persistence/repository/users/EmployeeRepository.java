package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;

public class EmployeeRepository extends UserRepository<EmployeeEntity> {

	public EmployeeRepository(EntityManager em) {
		super(em);
	}
	


}
