package br.edu.utfpr.libex7.adapters.persistence.service.users;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;

public interface IUserPersistenceService<T extends UserEntity> {

    T save(T user);

    Optional<T> findById(Long id);

    List<T> findAll();

    void remove(Long id);

    List<T> findByName(String name);
}
