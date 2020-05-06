package br.edu.utfpr.adapters.gui.handlers.books;

import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.ports.in.books.SaveBookUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ButtonSaveBookHandler implements EventHandler<ActionEvent> {
	
	
	private final SaveBookUseCase useCase;
	private final Book book;

	public ButtonSaveBookHandler(SaveBookUseCase useCase, Book book) {
		this.useCase = useCase;
		this.book = book;
	}

	@Override
	public void handle(ActionEvent event) {
		useCase.save(book);
		Alert alert = new Alert(AlertType.CONFIRMATION, "Livro cadastrado com sucesso");
		alert.showAndWait();
		
	}
}