package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.authors.SearchAuthorController;
import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemSearchAuthorHandler implements EventHandler<ActionEvent> {
	private final AuthorController authorController;

	public MenuItemSearchAuthorHandler(AuthorController authorController) {
		this.authorController = authorController;
	}

	@Override
	public void handle(ActionEvent event) {
		SearchAuthorController searchAuthorController = authorController.getSearchAuthorController();
		SearchAuthorView searchAuthorView = searchAuthorController.getView();
		searchAuthorView.show();
	}
}