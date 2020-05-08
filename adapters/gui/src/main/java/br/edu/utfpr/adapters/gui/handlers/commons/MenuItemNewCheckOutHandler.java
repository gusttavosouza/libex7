package br.edu.utfpr.adapters.gui.handlers.commons;

import java.util.List;

import br.edu.utfpr.adapters.gui.controllers.checkouts.CheckOutController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.SaveCheckOutController;
import br.edu.utfpr.adapters.gui.views.checkouts.SaveCheckOutView;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class MenuItemNewCheckOutHandler implements EventHandler<ActionEvent> {
	
	private final CheckOutController checkOutController;
	private final SearchUserUseCase searchUserUseCase;
	private final SearchCopyUseCase searchCopyUseCase;

	public MenuItemNewCheckOutHandler(CheckOutController checkOutController, SearchUserUseCase searchUserUseCase, SearchCopyUseCase searchCopyUseCase) {
		this.checkOutController = checkOutController;
		this.searchUserUseCase = searchUserUseCase;
		this.searchCopyUseCase = searchCopyUseCase;
	}

	@Override
	public void handle(ActionEvent event) {
		SaveCheckOutController saveCheckOutController = checkOutController.getSaveCheckOutController();
		SaveCheckOutView saveCheckOutView = saveCheckOutController.getView();		
		
		List<User> users = searchUserUseCase.findAll();
		List<Copy> copies = searchCopyUseCase.findAll();
		
		ComboBox<Copy> cmbCopy = saveCheckOutView.getCmbCopy();
		ComboBox<User> cmbUser = saveCheckOutView.getCmbUser();
		
		cmbCopy.getItems().clear();
		cmbUser.getItems().clear();
		
		cmbUser.getItems().setAll(FXCollections.observableArrayList(users));
		cmbCopy.getItems().setAll(FXCollections.observableArrayList(copies));
		
		
		saveCheckOutView.show();
	}
}