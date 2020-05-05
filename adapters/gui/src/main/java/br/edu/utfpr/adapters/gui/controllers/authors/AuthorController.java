package br.edu.utfpr.adapters.gui.controllers.authors;

import br.edu.utfpr.adapters.gui.views.authors.AuthorView;
import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import lombok.Getter;


public class AuthorController {
	
	private final SaveAuthorController saveAuthorController;
	private final SearchAuthorController searchAuthorController;
	
	@Getter
	private AuthorView authorView;
	
	
	public AuthorController(SaveAuthorController saveAuthorController,
							SearchAuthorController searchAuthorController) {
		this.saveAuthorController = saveAuthorController;
		this.searchAuthorController = searchAuthorController;
		SaveAuthorView saveAuthorView = this.saveAuthorController.getView();
		SearchAuthorView searchAuthorView = this.searchAuthorController.getView();
		this.authorView = new AuthorView(saveAuthorView, searchAuthorView);
	}


	
	

}
