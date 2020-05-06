package br.edu.utfpr.adapters.gui.controllers.users.students;

import br.edu.utfpr.adapters.gui.handlers.users.students.ButtonSaveStudentHandler;
import br.edu.utfpr.adapters.gui.views.users.students.SaveStudentView;
import br.edu.utfpr.libex7.application.ports.in.users.SaveUserUseCase;
import javafx.scene.control.Button;
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
    	saveButton.setOnAction(new ButtonSaveStudentHandler(view, useCase));
	}

    
  
    
}
