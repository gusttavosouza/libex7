package br.edu.utfpr.libex7.application.service.categories;

import br.edu.utfpr.libex7.application.ports.out.categories.RemoveCategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RemoveCategoryServiceTest {

    private RemoveCategoryPort port;
    private RemoveCategoryService service;

    @BeforeEach
    public void setup(){
        this.port = mock(RemoveCategoryPort.class);
        this.service = new RemoveCategoryService(port);
    }

    @Test
    @DisplayName("Given Category Id When Remove Then Do Nothing")
    public void givenCategoryIdWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(port,times(1)).remove(anyLong());
    }
}
