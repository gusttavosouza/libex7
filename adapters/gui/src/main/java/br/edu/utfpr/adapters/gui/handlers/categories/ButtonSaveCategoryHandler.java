package br.edu.utfpr.adapters.gui.handlers.categories;

import br.edu.utfpr.adapters.gui.views.categories.SaveCategoryView;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.categories.SaveCategoryUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ButtonSaveCategoryHandler implements EventHandler<ActionEvent> {
	
	private final SaveCategoryUseCase useCase;
	private final SaveCategoryView view;

	public ButtonSaveCategoryHandler(SaveCategoryUseCase useCase, SaveCategoryView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		TextField txtDescription = view.getTxtDescription();
		String description = txtDescription.getText().toUpperCase().trim();
		Category category = new Category();
		category.setDescription(description);
		useCase.save(category);
		Alert alert = new Alert(AlertType.CONFIRMATION, "Categoria cadastrada com sucesso");
		alert.showAndWait();
		
	}
}