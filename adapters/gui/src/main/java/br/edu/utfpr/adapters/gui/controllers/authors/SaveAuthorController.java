package br.edu.utfpr.adapters.gui.controllers.authors;

import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SaveAuthorUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    	TextField txtName = view.getTxtName();
		String name = txtName.getText().toUpperCase().trim();
		Author author = new Author();
		author.setName(name);
    	saveButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				useCase.save(author);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Autor cadastrado com sucesso");
				alert.showAndWait();
				
			}
		});
	}

    
  
    
}
