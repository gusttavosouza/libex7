package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.books.SaveBookController;
import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuItemNewBookHandler implements EventHandler<ActionEvent> {
	private final BookController bookController;

	public MenuItemNewBookHandler(BookController bookController) {
		this.bookController = bookController;
	}

	@Override
	public void handle(ActionEvent event) {
		SaveBookController saveBookController = bookController.getSaveBookController();
		SaveBookView saveBookView = saveBookController.getView();
		saveBookView.show();

	}
}