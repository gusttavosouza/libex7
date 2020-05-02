package br.edu.utfpr.libex7.application.service.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.ports.out.phones.SavePhonePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SavePhoneServiceTest {

    private SavePhonePort port;
    private SavePhoneService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SavePhonePort.class);
        this.service = new SavePhoneService(port);
    }

    @Test
    @DisplayName("Given New Phone When Save Then Return Saved Phone")
    public void givenNewPhoneWhenSaveThenReturnSavedPhone(){
        Phone phone = new Phone();
        when(port.save(any(Phone.class))).thenReturn(phone);
        Phone savedPhone = service.save(phone);
        assertThat(savedPhone).isNotNull();
    }

}
