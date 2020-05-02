package br.edu.utfpr.libex7.application.service.users;

import br.edu.utfpr.libex7.application.ports.out.users.RemoveUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RemoveUserServiceTest {

    private RemoveUserPort port;
    private RemoveUserService service;

    @BeforeEach
    public void setup(){
        this.port = mock(RemoveUserPort.class);
        this.service = new RemoveUserService(port);
    }

    @Test
    @DisplayName("Given User Id When Remove Then Do Nothing")
    public void givenUserIdWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(port,times(1)).remove(anyLong());
    }
}
