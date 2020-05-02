package br.edu.utfpr.libex7.adapters.persistence.adapters.phones;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.phones.PhonePersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.phones.PhonePersistenceService;
import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.ports.out.phones.SavePhonePort;
import br.edu.utfpr.libex7.application.ports.out.phones.SearchPhonePort;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PhonePersistenceAdapter  implements SavePhonePort, SearchPhonePort {

    private final PhonePersistenceService service;
    private final PhonePersistenceMapper mapper;

    @Override
    public List<Phone> findByUserId(Long id) {
        List<PhoneEntity> phoneEntities = service.findByUserId(id);
        List<Phone> phones = new ArrayList<>();
        phoneEntities.forEach(ph -> phones.add(mapper.mapToDomain(ph)));
        return phones;
    }

    @Override
    public Phone save(Phone phone) {
        PhoneEntity phoneEntity = mapper.mapToEntity(phone);
        service.save(phoneEntity);
        return mapper.mapToDomain(phoneEntity);
    }
}
