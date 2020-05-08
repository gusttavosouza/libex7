package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.users.employees.EmployeeController;
import br.edu.utfpr.adapters.gui.controllers.users.employees.SaveEmployeeController;
import br.edu.utfpr.adapters.gui.views.users.employees.SaveEmployeeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class MenuItemNewEmployeeHandler implements EventHandler<ActionEvent> {
	private final EmployeeController employeeController;

	public MenuItemNewEmployeeHandler(EmployeeController employeeController) {
		this.employeeController = employeeController;
	}

	@Override
	public void handle(ActionEvent event) {
	SaveEmployeeController saveEmployeeController = employeeController.getSaveEmployeeController();
		SaveEmployeeView saveEmployeeView = saveEmployeeController.getView();
		
		TextField txtDob = saveEmployeeView.getTxtDob();
		TextField txtEmployeeNumber = saveEmployeeView.getTxtEmployeeNumber();
		TextField txtName = saveEmployeeView.getTxtName();
		
		txtDob.clear();
		txtEmployeeNumber.clear();
		txtName.clear();
		
		saveEmployeeView.show();
	}
}