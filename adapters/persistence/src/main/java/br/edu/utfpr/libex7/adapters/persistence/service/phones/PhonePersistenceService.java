package br.edu.utfpr.libex7.adapters.persistence.service.phones;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.phones.PhoneRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PhonePersistenceService implements IPhonePersistenceService  {

    private final PhoneRepository repository;

    @Override
    public PhoneEntity save(PhoneEntity phoneEntity) {
        return repository.save(phoneEntity);
    }

    @Override
    public List<PhoneEntity> findByUserId(Long id) {
        return repository.findByUserId(id);
    }
}
