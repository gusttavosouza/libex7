package br.edu.utfpr.adapters.gui.controllers.authors;

import br.edu.utfpr.adapters.gui.handlers.authors.ButtonSaveAuthorHandler;
import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import br.edu.utfpr.libex7.application.ports.in.authors.SaveAuthorUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SaveAuthorController {

	


	private final SaveAuthorUseCase useCase;
    private final SaveAuthorView view;
    
    
	public SaveAuthorController(SaveAuthorUseCase useCase, SaveAuthorView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveAuthorUseCase useCase, SaveAuthorView view) {
		Button saveButton = view.getSaveButton();
    	saveButton.setOnAction(new ButtonSaveAuthorHandler(view, useCase));
	}

    
  
    
}
