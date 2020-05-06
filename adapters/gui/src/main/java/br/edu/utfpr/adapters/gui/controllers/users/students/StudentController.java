package br.edu.utfpr.adapters.gui.controllers.users.students;

import lombok.Getter;

@Getter
public class StudentController {
	
	private final SaveStudentController saveStudentController;
	private final SearchStudentController searchStudentController;
	
	
	public StudentController(SaveStudentController saveStudentController,
							SearchStudentController searchStudentController) {
		this.saveStudentController = saveStudentController;
		this.searchStudentController = searchStudentController;
	}


	
	

}
