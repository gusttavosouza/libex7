package br.edu.utfpr.adapters.gui.controllers.categories;

import br.edu.utfpr.adapters.gui.views.categories.SaveCategoryView;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.categories.SaveCategoryUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    	TextField txtDescription = view.getTxtDescription();
		String description = txtDescription.getText().toUpperCase().trim();
		Category category = new Category();
		category.setDescription(description);
    	saveButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				useCase.save(category);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Categoria cadastrada com sucesso");
				alert.showAndWait();
				
			}
		});
	}

    
  
    
}
