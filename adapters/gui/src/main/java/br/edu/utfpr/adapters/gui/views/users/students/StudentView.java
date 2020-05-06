package br.edu.utfpr.adapters.gui.views.users.students;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class StudentView extends BorderPane {
	
	private final SaveStudentView saveStudentView;
	private final SearchStudentView searchStudentView;
	
	public StudentView(SaveStudentView saveStudentView, SearchStudentView searchStudentView) {
		this.saveStudentView = saveStudentView;
		this.searchStudentView = searchStudentView;
		init();
	}
	
	private void init() {	
		GridPane gridPane = new GridPane();
		gridPane.add(saveStudentView, 1, 1);
		gridPane.add(searchStudentView, 1, 2);
		
		this.setCenter(gridPane);
		GridPane.setHgrow(gridPane,  Priority.ALWAYS);
		GridPane.setVgrow(gridPane,  Priority.ALWAYS);
	}
	
	

}
