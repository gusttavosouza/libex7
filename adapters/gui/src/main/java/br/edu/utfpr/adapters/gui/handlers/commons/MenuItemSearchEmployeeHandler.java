package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.users.employees.EmployeeController;
import br.edu.utfpr.adapters.gui.controllers.users.employees.SearchEmployeeController;
import br.edu.utfpr.adapters.gui.views.users.employees.SearchEmployeeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemSearchEmployeeHandler implements EventHandler<ActionEvent> {
	
	private final EmployeeController employeeController;

	public MenuItemSearchEmployeeHandler(EmployeeController employeeController) {
		this.employeeController = employeeController;
	}

	@Override
	public void handle(ActionEvent event) {
		 SearchEmployeeController searchEmployeeController = employeeController.getSearchEmployeeController();
		 SearchEmployeeView searchEmployeeView = searchEmployeeController.getView();
		 searchEmployeeView.show();

		
	}
}	