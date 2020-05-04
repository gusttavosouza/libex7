package br.edu.utfpr.libex7.application.service.copies;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;

import br.edu.utfpr.libex7.application.ports.out.copies.RemoveCopyPort;

public class RemoveCopyServiceTest {
	
	private RemoveCopyService service;
	private RemoveCopyPort port;
	
	@BeforeEach
	public void setup() {
		this.port = mock(RemoveCopyPort.class);
		this.service = new RemoveCopyService(port);
	}
	
	@Test
	@DisplayName("Given Copy Id When Remove Then Do Nothing")
	public void givenCopyIdWhenRemoveThenDoNothing() {
		service.remove(1L);
		verify(port, times(1)).remove(anyLong());
	}

}
