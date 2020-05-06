package br.edu.utfpr.adapters.gui.controllers.users.employees;

import br.edu.utfpr.adapters.gui.handlers.users.employees.ButtonSaveEmployeeHandler;
import br.edu.utfpr.adapters.gui.views.users.employees.SaveEmployeeView;
import br.edu.utfpr.libex7.application.ports.in.users.SaveUserUseCase;
import javafx.scene.control.Button;
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
    	saveButton.setOnAction(new ButtonSaveEmployeeHandler(view, useCase));
	}

    
  
    
}
