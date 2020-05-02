package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.AbstractMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.phones.PhonePersistenceMapper;
import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class UserPersistenceMapper<X extends User, Y extends UserEntity> implements AbstractMapper<X, Y> {

    private final PhonePersistenceMapper phonePersistenceMapper;

    @Override
    public X mapToDomain(Y userEntity) {
        X user = newInstanceDomain();
        List<PhoneEntity> phoneEntities = userEntity.getPhones();
        phoneEntities.forEach(ph -> user.addPhone(phonePersistenceMapper.mapToDomain(ph)));
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setDob(userEntity.getDob());
        return user;
    }

    @Override
    public Y mapToEntity(X user) {
        Y userEntity = newInstanceEntity();
        List<Phone> phones = user.getPhones();
        phones.forEach(ph -> userEntity.addPhone(phonePersistenceMapper.mapToEntity(ph)));
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setDob(user.getDob());
        return userEntity;
    }

    protected abstract  X newInstanceDomain();

    protected abstract  Y newInstanceEntity();
}
