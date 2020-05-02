package br.edu.utfpr.libex7.application.service.authors;

import br.edu.utfpr.libex7.application.ports.out.authors.RemoveAuthorPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RemoveAuthorServiceTest {

    private RemoveAuthorPort port;
    private RemoveAuthorService service;

    @BeforeEach
    public void setup(){
        this.port = mock(RemoveAuthorPort.class);
        this.service = new RemoveAuthorService(port);
    }

    @Test
    @DisplayName("Given Author Id When Remove Then Do Nothing")
    public void givenAuthorIdWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(port,times(1)).remove(anyLong());
    }
}
