package br.edu.utfpr.libex7.application.ports.out.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;

public interface SavePhonePort {
    Phone save(Phone phone);
}
