package br.edu.utfpr.libex7.adapters.persistence.service.phones;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;

import java.util.List;

public interface IPhonePersistenceService {
    PhoneEntity save(PhoneEntity phoneEntity);
    List<PhoneEntity> findByUserId(Long id);
}
