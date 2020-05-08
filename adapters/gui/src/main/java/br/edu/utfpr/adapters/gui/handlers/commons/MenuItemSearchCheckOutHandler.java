package br.edu.utfpr.adapters.gui.handlers.commons;

import java.util.List;

import br.edu.utfpr.adapters.gui.controllers.checkouts.CheckOutController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.SearchCheckOutController;
import br.edu.utfpr.adapters.gui.views.checkouts.SearchCheckOutView;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class MenuItemSearchCheckOutHandler implements EventHandler<ActionEvent> {
	
	private final CheckOutController checkOutController;
	private final SearchUserUseCase searchUserUseCase;
	private final SearchCopyUseCase searchCopyUseCase;

	public MenuItemSearchCheckOutHandler(CheckOutController checkOutController, SearchUserUseCase searchUserUseCase, SearchCopyUseCase searchCopyUseCase) {
		this.checkOutController = checkOutController;
		this.searchUserUseCase = searchUserUseCase;
		this.searchCopyUseCase = searchCopyUseCase;
	}

	@Override
	public void handle(ActionEvent event) {
		SearchCheckOutController searchCheckOutController = checkOutController.getSearchCheckOutController();
		SearchCheckOutView searchCheckOutView = searchCheckOutController.getView();
		
		ComboBox<Copy> cmbCopy = searchCheckOutView.getCmbCopy();
		ComboBox<User> cmbUser = searchCheckOutView.getCmbUser();
		
		cmbCopy.getItems().clear();
		cmbUser.getItems().clear();
		
		List<User> users = searchUserUseCase.findAll();
		List<Copy> copies = searchCopyUseCase.findAll();
		
		
		cmbUser.getItems().setAll(users);
		cmbCopy.getItems().setAll(copies);
		

		searchCheckOutView.show();

	}
}