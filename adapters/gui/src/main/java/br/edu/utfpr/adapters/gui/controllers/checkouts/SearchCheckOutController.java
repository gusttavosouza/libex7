package br.edu.utfpr.adapters.gui.controllers.checkouts;

import br.edu.utfpr.adapters.gui.handlers.checkouts.ButtonSearchCheckOutHandler;
import br.edu.utfpr.adapters.gui.views.checkouts.SearchCheckOutView;
import br.edu.utfpr.libex7.application.ports.in.checkout.SearchCheckOutUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SearchCheckOutController {
	
	
	private final SearchCheckOutUseCase useCase;
	private final SearchCheckOutView view;

	public SearchCheckOutController(SearchCheckOutUseCase useCase, SearchCheckOutView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}

	private void init() {
		Button button = view.getSearchButton();
		button.setOnAction(new ButtonSearchCheckOutHandler(useCase, view));
		
	}

}
