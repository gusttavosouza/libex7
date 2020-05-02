package br.edu.utfpr.libex7.application.service.phones;

import br.edu.utfpr.libex7.application.domain.phones.Phone;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.ports.out.phones.SearchPhonePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchPhoneServiceTest {

    private SearchPhonePort port;
    private SearchPhoneService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SearchPhonePort.class);
        this.service = new SearchPhoneService(port);
    }

    @Test
    @DisplayName("Given User Id When Search Then Return Phone")
    public void givenUserIdWhenSearchThenReturnPhone(){
        Phone phone = new Phone(new Employee(), 12123123213L);

        when(port.findByUserId(anyLong())).thenReturn(Arrays.asList(phone));

        List<Phone> phones = service.findByUserId(1L);
        assertFalse(phones.isEmpty());
    }

}
