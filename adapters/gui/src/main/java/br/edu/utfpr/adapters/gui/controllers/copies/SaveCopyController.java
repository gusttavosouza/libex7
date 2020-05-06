package br.edu.utfpr.adapters.gui.controllers.copies;

import br.edu.utfpr.adapters.gui.handlers.copies.ButtonSaveCopyHandler;
import br.edu.utfpr.adapters.gui.views.copies.SaveCopyView;
import br.edu.utfpr.libex7.application.ports.in.copies.SaveCopyUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SaveCopyController {


	private final SaveCopyUseCase useCase;
    private final SaveCopyView view;
    
    
	public SaveCopyController(SaveCopyUseCase useCase, SaveCopyView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveCopyUseCase useCase, SaveCopyView view) {
		Button saveButton = view.getSaveButton();
    	saveButton.setOnAction(new ButtonSaveCopyHandler(useCase, view));
	}

    
  
    
}
