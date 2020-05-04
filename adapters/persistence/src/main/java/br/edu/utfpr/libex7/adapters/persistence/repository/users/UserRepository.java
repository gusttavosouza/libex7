package br.edu.utfpr.libex7.adapters.persistence.repository.users;


import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class UserRepository extends GenericRepository<UserEntity, Long> {

    public UserRepository(EntityManager em) {
        super(em);
    }

	public List<UserEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
