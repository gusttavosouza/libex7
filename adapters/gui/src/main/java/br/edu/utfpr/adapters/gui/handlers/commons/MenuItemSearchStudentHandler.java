package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.users.students.SearchStudentController;
import br.edu.utfpr.adapters.gui.controllers.users.students.StudentController;
import br.edu.utfpr.adapters.gui.views.users.students.SearchStudentView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemSearchStudentHandler implements EventHandler<ActionEvent> {
	private final StudentController studentController;

	public MenuItemSearchStudentHandler(StudentController studentController) {
		this.studentController = studentController;
	}

	@Override
	public void handle(ActionEvent event) {
		 SearchStudentController searchStudentController = studentController.getSearchStudentController();
		 SearchStudentView searchStudentView = searchStudentController.getView();
		 searchStudentView.show();
	}
}