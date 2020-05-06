package br.edu.utfpr.adapters.gui.controllers.users.employees;

import java.time.LocalDate;

import br.edu.utfpr.adapters.gui.views.users.employees.SaveEmployeeView;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.ports.in.users.SaveUserUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SaveEmployeeController {

	private final SaveUserUseCase useCase;
    private final SaveEmployeeView view;
    
    
	public SaveEmployeeController(SaveUserUseCase useCase, SaveEmployeeView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveUserUseCase useCase, SaveEmployeeView view) {
		Button saveButton = view.getSaveButton();
    	TextField txtName = view.getTxtName();
    	TextField txtDob = view.getTxtDob();
    	TextField txtEmployeeNumber = view.getTxtEmployeeNumber();
		String name = txtName.getText().toUpperCase().trim();
		LocalDate dob = LocalDate.parse(txtDob.getText());
		Long studentNumber = Long.parseLong(txtEmployeeNumber.getText());
		
		Employee user = new Employee();
		user.setName(name);
		user.setDob(dob);
		user.setEmployeeNumber(studentNumber);
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
