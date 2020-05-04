package br.edu.utfpr.libex7.application.service.copies;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.ports.out.copies.SearchCopyPort;

public class SearchCopyServiceTest {
	
	private SearchCopyService service;
	private SearchCopyPort port;
	
	@BeforeEach
	public void setup() {
		this.port = mock(SearchCopyPort.class);
		this.service = new SearchCopyService(port);
	}
	
	@Test
	@DisplayName("Given Copy Id When Search Then Return Copy")
	public void givenCopyIdWhenSearchThenReturnCopy() {
		Copy copy = new Copy(1L);
		when(port.findById(anyLong())).thenReturn(Optional.ofNullable(copy));
		Optional<Copy> optionalCopy = service.findById(anyLong());
		assertTrue(optionalCopy.isPresent());
	}
	
	@Test
	@DisplayName("Given Find All Method When Is Called Then Copy List")
	public void givenFindAllMethodWhenIsCalledThenCopyList() {
		Copy copy = new Copy(1L);
		when(port.findAll()).thenReturn(Arrays.asList(copy));
		List<Copy> copies = service.findAll();
		assertFalse(copies.isEmpty());
	}

}
