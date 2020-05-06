package br.edu.utfpr.libex7.adapters.persistence.service.users;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersistenceService<T extends UserEntity> implements IUserPersistenceService<T> {

    private final UserRepository<T> userRepository;

	@Override
	public T save(T user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<T> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<T> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		userRepository.remove(id);
		
	}

	@Override
	public List<T> findByName(String name) {
		return userRepository.findByName(name);
	}

	
    
   
}
