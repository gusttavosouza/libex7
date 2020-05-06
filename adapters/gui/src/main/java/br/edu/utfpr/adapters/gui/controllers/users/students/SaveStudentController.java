package br.edu.utfpr.adapters.gui.controllers.users.students;

import java.time.LocalDate;

import br.edu.utfpr.adapters.gui.views.users.students.SaveStudentView;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.ports.in.users.SaveUserUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SaveStudentController {

	private final SaveUserUseCase useCase;
    private final SaveStudentView view;
    
    
	public SaveStudentController(SaveUserUseCase useCase, SaveStudentView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveUserUseCase useCase, SaveStudentView view) {
		Button saveButton = view.getSaveButton();
    	TextField txtName = view.getTxtName();
    	TextField txtDob = view.getTxtDob();
    	TextField txtStudentNumber = view.getTxtStudentNumber();
		String name = txtName.getText().toUpperCase().trim();
		LocalDate dob = LocalDate.parse(txtDob.getText());
		Long studentNumber = Long.parseLong(txtStudentNumber.getText());
		
		Student user = new Student();
		user.setName(name);
		user.setDob(dob);
		user.setStudentNumber(studentNumber);
    	saveButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				useCase.save(user);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Autor cadastrado com sucesso");
				alert.showAndWait();
				
			}
		});
	}

    
  
    
}
