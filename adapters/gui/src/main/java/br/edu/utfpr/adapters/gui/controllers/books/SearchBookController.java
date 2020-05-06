package br.edu.utfpr.adapters.gui.controllers.books;

import br.edu.utfpr.adapters.gui.handlers.books.ButtonSearchBookHandler;
import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SearchBookController {


	private final SearchBookUseCase useCase;
	private final SearchBookView view;

	public SearchBookController(SearchBookUseCase useCase, SearchBookView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}

	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new ButtonSearchBookHandler(useCase, view));
		
	}

}
