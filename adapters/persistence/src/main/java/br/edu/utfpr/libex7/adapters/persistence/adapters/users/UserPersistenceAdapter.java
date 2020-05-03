package br.edu.utfpr.libex7.adapters.persistence.adapters.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.UserPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.users.UserPersistenceService;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.out.users.RemoveUserPort;
import br.edu.utfpr.libex7.application.ports.out.users.SaveUserPort;
import br.edu.utfpr.libex7.application.ports.out.users.SearchUserPort;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements SaveUserPort, SearchUserPort, RemoveUserPort {

    private final UserPersistenceService service;
    private final UserPersistenceMapper mapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = mapper.mapToEntity(user);
        service.save(userEntity);
        return mapper.mapToDomain(userEntity);
    }

    @Override
    public void remove(Long id) {
        service.remove(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> optionalUserEntity = service.findById(id);
        if(optionalUserEntity.isPresent()){
            UserEntity userEntity = optionalUserEntity.get();
            return Optional.ofNullable(mapper.mapToDomain(userEntity));
        }
        return Optional.empty();
    }

    @Override
    public List<User> findByName(String name) {
        List<UserEntity> userEntities = service.findByName(name);
        List<User> users = new ArrayList<>();
        userEntities.forEach(u -> users.add(mapper.mapToDomain(u)));
        return users;
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = service.findAll();
        List<User> users = new ArrayList<>();
        userEntities.forEach(u -> users.add(mapper.mapToDomain(u)));
        return users;
    }
}
