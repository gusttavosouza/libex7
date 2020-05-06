package br.edu.utfpr.libex7.application.domain.authors;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class Author {

    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

	public Author(Long id) {
		this.id = id;
	}
    
    

}
