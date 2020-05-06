package br.edu.utfpr.adapters.gui.views.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import lombok.Getter;


@Getter
public class SearchCategoryView extends GridPane {
	
	
	private Label lblId = new Label("ID:");
	private Label lblDescription = new Label("Descrição:");
	private TextField txtID = new TextField("ID:");
	private TextField txtDescription = new TextField("Descrição:");
	private Button searchButton = new Button("Buscar");
	private ListView<Category> listView = new ListView<>();

	public SearchCategoryView() {
	    init();	
	}
	
	private void init() {
		add(lblId, 1, 1);
		add(txtID, 2, 1);
		add(lblDescription, 1, 2);
		add(txtDescription, 2, 2);
		add(searchButton, 2, 3);
		addRow(4, listView);
	}

}
