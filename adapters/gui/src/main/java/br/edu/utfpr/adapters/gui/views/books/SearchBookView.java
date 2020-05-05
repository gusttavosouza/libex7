package br.edu.utfpr.adapters.gui.views.books;

import br.edu.utfpr.libex7.application.domain.books.Book;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import lombok.Getter;

@Getter
public class SearchBookView extends GridPane {
	
	
	private Label lblId = new Label("ID:");
	private Label lblTitle = new Label("Título");
	private TextField txtID = new TextField("ID:");
	private TextField txtTitle = new TextField("Título:");
	private Button searchButton = new Button("Buscar");
	private ListView<Book> listView = new ListView<>();

	public SearchBookView() {
	    init();	
	}
	
	private void init() {
		add(lblId, 1, 1);
		add(txtID, 2, 1);
		add(lblTitle, 1, 2);
		add(txtTitle, 2, 2);
		add(searchButton, 2, 3);
		addRow(4, listView);
	}

}
