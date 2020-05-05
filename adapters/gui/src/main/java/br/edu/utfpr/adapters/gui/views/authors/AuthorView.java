package br.edu.utfpr.adapters.gui.views.authors;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class AuthorView extends BorderPane {
	
	private final SaveAuthorView saveAuthorView;
	private final SearchAuthorView searchAuthorView;
	
	public AuthorView(SaveAuthorView saveAuthorView, SearchAuthorView searchAuthorView) {
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
