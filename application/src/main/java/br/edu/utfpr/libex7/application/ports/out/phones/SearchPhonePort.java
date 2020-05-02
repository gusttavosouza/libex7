package br.edu.utfpr.libex7.application.ports.out.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;

import java.util.List;

public interface SearchPhonePort {
    List<Phone> findByUserId(Long id);
}
