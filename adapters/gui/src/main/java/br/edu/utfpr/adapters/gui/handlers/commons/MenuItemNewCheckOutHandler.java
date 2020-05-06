package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.checkouts.CheckOutController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.SaveCheckOutController;
import br.edu.utfpr.adapters.gui.views.checkouts.SaveCheckOutView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemNewCheckOutHandler implements EventHandler<ActionEvent> {
	private final CheckOutController checkOutController;

	public MenuItemNewCheckOutHandler(CheckOutController checkOutController) {
		this.checkOutController = checkOutController;
	}

	@Override
	public void handle(ActionEvent event) {
		SaveCheckOutController saveCheckOutController = checkOutController.getSaveCheckOutController();
		SaveCheckOutView saveCheckOutView = saveCheckOutController.getView();
		saveCheckOutView.show();
	}
}