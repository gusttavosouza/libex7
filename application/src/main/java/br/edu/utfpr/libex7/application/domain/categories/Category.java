package br.edu.utfpr.libex7.application.domain.categories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class Category {

    @Getter
    private Long id;

    @Getter
    @Setter
    private String description;

	public Category(Long id) {
		this.id = id;
	}
    
    
}
