package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.copies.CopyController;
import br.edu.utfpr.adapters.gui.controllers.copies.SearchCopyController;
import br.edu.utfpr.adapters.gui.views.copies.SearchCopyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemSearchCopyHandler implements EventHandler<ActionEvent> {
	private final CopyController copyController;

	public MenuItemSearchCopyHandler(CopyController copyController) {
		this.copyController = copyController;
	}

	@Override
	public void handle(ActionEvent event) {
	      SearchCopyController searchCopyController = copyController.getSearchCopyController();
	      SearchCopyView searchCopyView = searchCopyController.getView();
	      searchCopyView.show();
	}
}