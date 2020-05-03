package br.edu.utfpr.libex7.application.ports.in.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;

public interface SavePhoneUseCase {
    Phone save(Phone phone);
}
