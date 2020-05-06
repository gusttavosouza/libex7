package br.edu.utfpr.libex7.adapters.persistence.adapters.users;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.UserPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.users.UserPersistenceService;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.out.users.RemoveUserPort;
import br.edu.utfpr.libex7.application.ports.out.users.SaveUserPort;
import br.edu.utfpr.libex7.application.ports.out.users.SearchUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersistenceAdapter<T extends UserEntity> implements SaveUserPort, SearchUserPort, RemoveUserPort {

    private final UserPersistenceService<T> service;
	private final UserPersistenceMapper<User, T> mapper;

	@Override
    public User save(User user) {
        T userEntity = mapper.mapToEntity(user);
        service.save(userEntity);
        return mapper.mapToDomain(userEntity);
    }

    @Override
    public void remove(Long id) {
        service.remove(id);
    }

	@Override
    public Optional<User> findById(Long id) {
      Optional<T> optionalUserEntity = service.findById(id);
        if(optionalUserEntity.isPresent()){
            T userEntity = optionalUserEntity.get();
            return Optional.ofNullable(mapper.mapToDomain(userEntity));
        }
        return Optional.empty();
    }

  
	@Override
    public List<User> findByName(String name) {
        List<T> userEntities = service.findByName(name);
        return mapper.mapToDomain(userEntities);
    }

	@Override
    public List<User> findAll() {
        List<T> userEntities = service.findAll();
        return mapper.mapToDomain(userEntities);
    }
}
