package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.users.students.SaveStudentController;
import br.edu.utfpr.adapters.gui.controllers.users.students.StudentController;
import br.edu.utfpr.adapters.gui.views.users.students.SaveStudentView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public  class MenuItemNewStudentHandler implements EventHandler<ActionEvent> {
	
	private final StudentController studentController;

	public MenuItemNewStudentHandler(StudentController studentController) {
		this.studentController = studentController;
	}

	@Override
	public void handle(ActionEvent event) {
		SaveStudentController saveStudentController = studentController.getSaveStudentController();
		SaveStudentView saveStudentView = saveStudentController.getView();
		
		TextField txtDob = saveStudentView.getTxtDob();
		TextField txtStudentNumber = saveStudentView.getTxtStudentNumber();
		TextField txtName = saveStudentView.getTxtName();
		
		txtDob.clear();
		txtStudentNumber.clear();
		txtName.clear();
		
		saveStudentView.show();
	}
}