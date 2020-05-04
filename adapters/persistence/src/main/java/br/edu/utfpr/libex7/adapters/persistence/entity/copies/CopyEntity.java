package br.edu.utfpr.libex7.adapters.persistence.entity.copies;

import java.time.LocalDate;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import lombok.Getter;
import lombok.Setter;

public class CopyEntity {

	
	@Getter
	private Long id;
	
	@Getter
	@Setter
	private StatusCopyDataEnum status;
	
	@Getter
	@Setter
	private BookEntity book;
	
	@Getter
	@Setter
	private LocalDate acquisitionDate;
	
	
	public CopyEntity(Long id) {
		this.id = id;
	}
	
	
	
	

}
