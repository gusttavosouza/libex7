package br.edu.utfpr.libex7.adapters.persistence.service.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserPersistenceService {

    UserEntity save(UserEntity user);

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAll();

    void remove(Long id);

    List<UserEntity> findByName(String name);
}
