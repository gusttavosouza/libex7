package br.edu.utfpr.adapters.gui.views.books;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class BookView extends BorderPane {
	
	private final SaveBookView saveAuthorView;
	private final SearchBookView searchAuthorView;
	
	public BookView(SaveBookView saveAuthorView, SearchBookView searchAuthorView) {
		this.saveAuthorView = saveAuthorView;
		this.searchAuthorView = searchAuthorView;
		init();
	}
	
	private void init() {	
		GridPane gridPane = new GridPane();
		gridPane.add(saveAuthorView, 1, 1);
		gridPane.add(searchAuthorView, 1, 2);
		gridPane.setMaxWidth(Double.MAX_VALUE);
		gridPane.setMaxHeight(Double.MAX_VALUE);
		this.setCenter(gridPane);
	}
	
	

}
