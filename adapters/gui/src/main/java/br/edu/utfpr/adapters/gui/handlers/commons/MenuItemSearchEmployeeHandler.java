package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.users.employees.EmployeeController;
import br.edu.utfpr.adapters.gui.controllers.users.employees.SearchEmployeeController;
import br.edu.utfpr.adapters.gui.views.users.employees.SearchEmployeeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class MenuItemSearchEmployeeHandler implements EventHandler<ActionEvent> {
	
	private final EmployeeController employeeController;

	public MenuItemSearchEmployeeHandler(EmployeeController employeeController) {
		this.employeeController = employeeController;
	}

	@Override
	public void handle(ActionEvent event) {
		 SearchEmployeeController searchEmployeeController = employeeController.getSearchEmployeeController();
		 SearchEmployeeView searchEmployeeView = searchEmployeeController.getView();
		 
		 TextField txtID = searchEmployeeView.getTxtID();
		 TextField txtName = searchEmployeeView.getTxtName();
		 TextField txtEmployeeNumber = searchEmployeeView.getTxtEmployeeNumber();
		 
		 
		 txtID.clear();
		 txtName.clear();
		 txtEmployeeNumber.clear();
		 
		 searchEmployeeView.show();

		
	}
}	