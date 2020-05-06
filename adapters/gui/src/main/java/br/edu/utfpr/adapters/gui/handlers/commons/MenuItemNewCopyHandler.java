package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.copies.CopyController;
import br.edu.utfpr.adapters.gui.controllers.copies.SaveCopyController;
import br.edu.utfpr.adapters.gui.views.copies.SaveCopyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public final class MenuItemNewCopyHandler implements EventHandler<ActionEvent> {
	private final CopyController copyController;

	public MenuItemNewCopyHandler(CopyController copyController) {
		this.copyController = copyController;
	}

	@Override
	public void handle(ActionEvent event) {
	     SaveCopyController saveCopyController = copyController.getSaveCopyController();
	     SaveCopyView saveCopyView = saveCopyController.getView();
	     saveCopyView.show();
	}
}