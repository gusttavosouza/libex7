package br.edu.utfpr.libex7.application.service.copies;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;
import br.edu.utfpr.libex7.application.ports.out.copies.SaveCopyPort;

public class SaveCopyServiceTest {
	
	private SaveCopyService service;
	private SaveCopyPort port;
	
	@BeforeEach
	public void setup() {
		this.port = mock(SaveCopyPort.class);
		this.service = new SaveCopyService(port);
	}
	
	@Test
	@DisplayName("Given Copy When Save Then Return Saved Copy")
	public void givenCopyWhenSaveThenReturnSavedCopy() {
		Copy copy = new Copy(1L);
		copy.setStatus(StatusCopyEnum.fromValue("Disponível"));
		copy.setBook(new Book(1L));
		copy.setAcquisitionDate(LocalDate.now());
		when(port.save(any(Copy.class))).thenReturn(copy);
		Copy savedCopy = service.save(copy);
		assertThat(savedCopy.getId()).isEqualTo(copy.getId());
		assertThat(savedCopy.getAcquisitionDate()).isEqualTo(copy.getAcquisitionDate());
		assertThat(savedCopy.getBook()).isEqualTo(copy.getBook());
		assertThat(savedCopy.getStatus()).isEqualTo(copy.getStatus());
	}

}
