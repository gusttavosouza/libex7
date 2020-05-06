package br.edu.utfpr.adapters.gui.controllers.copies;

import br.edu.utfpr.adapters.gui.handlers.copies.ButtonSearchCopyHandler;
import br.edu.utfpr.adapters.gui.views.copies.SearchCopyView;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SearchCopyController {


	private final SearchCopyUseCase useCase;
    private final SearchCopyView view;
    
    
	public SearchCopyController(SearchCopyUseCase useCase, SearchCopyView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new ButtonSearchCopyHandler(useCase, view));
		
	}
    
    


}
