package br.edu.utfpr.adapters.gui.controllers.users.employees;

import br.edu.utfpr.adapters.gui.views.users.employees.EmployeeView;
import br.edu.utfpr.adapters.gui.views.users.employees.SaveEmployeeView;
import br.edu.utfpr.adapters.gui.views.users.employees.SearchEmployeeView;
import lombok.Getter;


public class EmployeeController {
	
	private final SaveEmployeeController saveEmployeeController;
	private final SearchEmployeeController searchEmployeeController;
	
	@Getter
	private EmployeeView userView;
	
	
	public EmployeeController(SaveEmployeeController saveEmployeeController,
							SearchEmployeeController searchEmployeeController) {
		this.saveEmployeeController = saveEmployeeController;
		this.searchEmployeeController = searchEmployeeController;
		SaveEmployeeView saveEmployeeView = this.saveEmployeeController.getView();
		SearchEmployeeView searchEmployeeView = this.searchEmployeeController.getView();
		this.userView = new EmployeeView(saveEmployeeView, searchEmployeeView);
	}


	
	

}
