package br.edu.utfpr.adapters.gui.controllers.authors;

import br.edu.utfpr.adapters.gui.handlers.authors.ButtonSearchAuthorHandler;
import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SearchAuthorController {

	private final SearchAuthorUseCase useCase;
    private final SearchAuthorView view;
    
    
	public SearchAuthorController(SearchAuthorUseCase useCase, SearchAuthorView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new ButtonSearchAuthorHandler(view, useCase));
		
	}
    
    


}
