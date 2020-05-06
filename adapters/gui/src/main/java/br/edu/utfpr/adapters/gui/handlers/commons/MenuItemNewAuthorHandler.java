package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.authors.SaveAuthorController;
import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemNewAuthorHandler implements EventHandler<ActionEvent> {
	private final AuthorController authorController;

	public MenuItemNewAuthorHandler(AuthorController authorController) {
		this.authorController = authorController;
	}

	@Override
	public void handle(ActionEvent event) {
		SaveAuthorController saveAuthorController = authorController.getSaveAuthorController();
		SaveAuthorView saveAuthorView = saveAuthorController.getView();
		saveAuthorView.show();
	}
}
