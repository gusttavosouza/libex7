package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.checkouts.CheckOutController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.SearchCheckOutController;
import br.edu.utfpr.adapters.gui.views.checkouts.SearchCheckOutView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemSearchCheckOutHandler implements EventHandler<ActionEvent> {
	private final CheckOutController checkOutController;

	public MenuItemSearchCheckOutHandler(CheckOutController checkOutController) {
		this.checkOutController = checkOutController;
	}

	@Override
	public void handle(ActionEvent event) {
		SearchCheckOutController searchCheckOutController = checkOutController.getSearchCheckOutController();
		SearchCheckOutView searchCheckOutView = searchCheckOutController.getView();
		searchCheckOutView.show();
	}
}