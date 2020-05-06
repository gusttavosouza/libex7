package br.edu.utfpr.adapters.gui.controllers.categories;

import br.edu.utfpr.adapters.gui.handlers.categories.ButtonSaveCategoryHandler;
import br.edu.utfpr.adapters.gui.views.categories.SaveCategoryView;
import br.edu.utfpr.libex7.application.ports.in.categories.SaveCategoryUseCase;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class SaveCategoryController {

	private final SaveCategoryUseCase useCase;
    private final SaveCategoryView view;
    
    
	public SaveCategoryController(SaveCategoryUseCase useCase, SaveCategoryView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveCategoryUseCase useCase, SaveCategoryView view) {
		Button saveButton = view.getSaveButton();
    	saveButton.setOnAction(new ButtonSaveCategoryHandler(useCase, view));
	}

    
  
    
}
