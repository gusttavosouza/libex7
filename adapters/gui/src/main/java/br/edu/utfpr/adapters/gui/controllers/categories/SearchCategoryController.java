package br.edu.utfpr.adapters.gui.controllers.categories;

import br.edu.utfpr.adapters.gui.handlers.categories.ButtonSearchCategoryHandler;
import br.edu.utfpr.adapters.gui.views.categories.SearchCategoryView;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SearchCategoryController {

	private final SearchCategoryUseCase useCase;
    private final SearchCategoryView view;
    
    
	public SearchCategoryController(SearchCategoryUseCase useCase, SearchCategoryView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new ButtonSearchCategoryHandler(useCase, view));
	}
    

}
