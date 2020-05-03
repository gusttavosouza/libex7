package br.edu.utfpr.libex7.application.service.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.ports.in.phones.SavePhoneUseCase;
import br.edu.utfpr.libex7.application.ports.out.phones.SavePhonePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SavePhoneService implements SavePhoneUseCase {

    private final SavePhonePort savePhonePort;

    @Override
    public Phone save(Phone phone) {
        return savePhonePort.save(phone);
    }
}
