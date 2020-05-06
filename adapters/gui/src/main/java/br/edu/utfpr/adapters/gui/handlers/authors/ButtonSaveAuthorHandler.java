package br.edu.utfpr.adapters.gui.handlers.authors;

import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SaveAuthorUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ButtonSaveAuthorHandler implements EventHandler<ActionEvent> {
	private final SaveAuthorView view;
	private final SaveAuthorUseCase useCase;

	public ButtonSaveAuthorHandler(SaveAuthorView view, SaveAuthorUseCase useCase) {
		this.view = view;
		this.useCase = useCase;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			TextField txtName = view.getTxtName();
			String name = txtName.getText().toUpperCase().trim();
			Author author = new Author();
			author.setName(name);
			useCase.save(author);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Autor cadastrado com sucesso");
			alert.showAndWait();
		}catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar autor");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
	}
}