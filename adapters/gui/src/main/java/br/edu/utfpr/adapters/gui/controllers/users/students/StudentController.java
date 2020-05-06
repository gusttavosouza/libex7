package br.edu.utfpr.adapters.gui.controllers.users.students;

import br.edu.utfpr.adapters.gui.views.users.students.SaveStudentView;
import br.edu.utfpr.adapters.gui.views.users.students.SearchStudentView;
import br.edu.utfpr.adapters.gui.views.users.students.StudentView;
import lombok.Getter;


public class StudentController {
	
	private final SaveStudentController saveStudentController;
	private final SearchStudentController searchStudentController;
	
	@Getter
	private StudentView userView;
	
	
	public StudentController(SaveStudentController saveStudentController,
							SearchStudentController searchStudentController) {
		this.saveStudentController = saveStudentController;
		this.searchStudentController = searchStudentController;
		SaveStudentView saveStudentView = this.saveStudentController.getView();
		SearchStudentView searchStudentView = this.searchStudentController.getView();
		this.userView = new StudentView(saveStudentView, searchStudentView);
	}


	
	

}
