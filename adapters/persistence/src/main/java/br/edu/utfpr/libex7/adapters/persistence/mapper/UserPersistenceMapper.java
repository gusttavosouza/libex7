package br.edu.utfpr.libex7.adapters.persistence.mapper;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.application.domain.users.User;

public class UserPersistenceMapper implements AbstractMapper<User, UserEntity> {

    @Override
    public User mapToDomain(UserEntity objEntity) {
        return null;
    }

    @Override
    public UserEntity mapToEntity(User objDomain) {
        return null;
    }
}
