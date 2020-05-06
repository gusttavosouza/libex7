package br.edu.utfpr.adapters.gui.controllers.checkouts;

import br.edu.utfpr.adapters.gui.views.checkouts.SaveCheckOutView;
import br.edu.utfpr.libex7.application.ports.in.checkout.SaveCheckOutUseCase;
import lombok.Getter;

@Getter
public class SaveCheckOutController {
	
	
	private final SaveCheckOutUseCase useCase;
    private final SaveCheckOutView view;
    
    
	public SaveCheckOutController(SaveCheckOutUseCase useCase, SaveCheckOutView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveCheckOutUseCase useCase, SaveCheckOutView view) {
		//	Button saveButton = view.getSaveButton();
    	//saveButton.setOnAction(new ButtonSaveCategoryHandler(useCase, view));
	}

}
