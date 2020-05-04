package br.edu.utfpr.libex7.application.domain.copies;

import java.time.LocalDate;

import br.edu.utfpr.libex7.application.domain.books.Book;
import lombok.Getter;
import lombok.Setter;

public class Copy {

	
	@Getter
	private Long id;
	
	@Getter
	@Setter
	private StatusCopyEnum status;
	
	@Getter
	@Setter
	private Book book;
	
	@Getter
	@Setter
	private LocalDate acquisitionDate;
	
	
	public Copy(Long id) {
		this.id = id;
	}
	
	
	
	

}
