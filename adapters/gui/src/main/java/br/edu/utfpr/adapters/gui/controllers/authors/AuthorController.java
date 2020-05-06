package br.edu.utfpr.adapters.gui.controllers.authors;

import lombok.Getter;


@Getter
public class AuthorController {
	
	private final SaveAuthorController saveAuthorController;
	private final SearchAuthorController searchAuthorController;
	
	
	public AuthorController(SaveAuthorController saveAuthorController,
							SearchAuthorController searchAuthorController) {
		this.saveAuthorController = saveAuthorController;
		this.searchAuthorController = searchAuthorController;
	}


	
	

}
