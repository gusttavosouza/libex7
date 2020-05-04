package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.AbstractMapper;
import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class UserPersistenceMapper<X extends User, Y extends UserEntity> implements AbstractMapper<X, Y> {

    @Override
    public X mapToDomain(Y userEntity) {
        Long id = userEntity.getId();
        X user = newInstanceDomain(id);
        List<UserEntity.PhoneEntity> phoneEntities = userEntity.getPhones();
        phoneEntities.forEach(ph -> user.addPhone(ph.getPhoneId().getNumber()));
        user.setName(userEntity.getName());
        user.setDob(userEntity.getDob());
        return user;
    }

    @Override
    public Y mapToEntity(X user) {
        Long id = user.getId();
        Y userEntity = newInstanceEntity(id);
        List<User.Phone> phones = user.getPhones();
        phones.forEach(ph -> userEntity.addPhone(ph.getNumber()));
        userEntity.setName(user.getName());
        userEntity.setDob(user.getDob());
        return userEntity;
    }

    protected abstract  X newInstanceDomain(Long id);

    protected abstract  Y newInstanceEntity(Long id);
}
