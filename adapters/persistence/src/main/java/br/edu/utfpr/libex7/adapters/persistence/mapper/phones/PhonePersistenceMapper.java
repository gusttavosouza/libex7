package br.edu.utfpr.libex7.adapters.persistence.mapper.phones;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.AbstractMapper;
import br.edu.utfpr.libex7.application.domain.phones.Phone;

public class PhonePersistenceMapper implements AbstractMapper<Phone, PhoneEntity> {


    @Override
    public Phone mapToDomain(PhoneEntity phoneEntity) {
        Phone phone = new Phone();
        phone.setNumber(phoneEntity.getNumber());
        return phone;
    }

    @Override
    public PhoneEntity mapToEntity(Phone phone) {
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setNumber(phone.getNumber());
        return phoneEntity;
    }
}
