package br.edu.utfpr.adapters.gui.handlers.commons;

import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.books.SearchBookController;
import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public final class MenuItemSearchBookHandler implements EventHandler<ActionEvent> {
	private final BookController bookController;

	public MenuItemSearchBookHandler(BookController bookController) {
		this.bookController = bookController;
	}

	@Override
	public void handle(ActionEvent event) {
		SearchBookController searchBookController = bookController.getSearchBookController();
		SearchBookView searchBookView = searchBookController.getView();
		
		TextField txtID = searchBookView.getTxtID();
		TextField txtTitle = searchBookView.getTxtTitle();
		
		txtID.clear();
		txtTitle.clear();
		searchBookView.show();
	}
}