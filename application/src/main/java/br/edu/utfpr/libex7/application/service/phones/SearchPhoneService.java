package br.edu.utfpr.libex7.application.service.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.ports.in.phones.SearchPhoneUseCase;
import br.edu.utfpr.libex7.application.ports.out.phones.SearchPhonePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SearchPhoneService implements SearchPhoneUseCase {

    private final SearchPhonePort searchPhonePort;

    @Override
    public List<Phone> findByUserId(Long id) {
        return searchPhonePort.findByUserId(id);
    }


}
