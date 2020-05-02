package br.edu.utfpr.libex7.application.ports.in.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;

import java.util.List;

public interface SearchPhoneUseCase {
    List<Phone> findByUserId(Long id);
}
