package br.edu.utfpr.adapters.gui.controllers.users.employees;

import lombok.Getter;


@Getter
public class EmployeeController {
	
	private final SaveEmployeeController saveEmployeeController;
	private final SearchEmployeeController searchEmployeeController;
	
	
	public EmployeeController(SaveEmployeeController saveEmployeeController,
							SearchEmployeeController searchEmployeeController) {
		this.saveEmployeeController = saveEmployeeController;
		this.searchEmployeeController = searchEmployeeController;
	}


	
	

}
