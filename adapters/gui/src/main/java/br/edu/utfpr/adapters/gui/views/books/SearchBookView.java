package br.edu.utfpr.adapters.gui.views.books;

import br.edu.utfpr.libex7.application.domain.books.Book;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import lombok.Getter;

@Getter
public class SearchBookView extends GridPane {
	
	
	private Label lblId = new Label("ID:");
	private Label lblTitle = new Label("Título");
	private Label lblAuthorName = new Label("Autor");
	private TextField txtID = new TextField();
	private TextField txtTitle = new TextField();
	private TextField txtAuthorName = new TextField();
	private Button searchButton = new Button("Buscar");
	private TableView<Book> tableView = new TableView<>();

	public SearchBookView() {
	    init();	
	}
	
	@SuppressWarnings("unchecked")
	private void init() {
		GridPane gridPane = new GridPane();
		gridPane.add(lblId, 1, 1);
		gridPane.add(txtID, 2, 1);
		gridPane.add(lblTitle, 1, 2);
		gridPane.add(txtTitle, 2, 2);
		gridPane.add(lblAuthorName, 1, 3);
		gridPane.add(txtAuthorName, 2, 3);
		gridPane.add(searchButton, 2, 3);
		
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		TableColumn<Book, String> columID = new TableColumn<>("ID");
		TableColumn<Book, String> columTitle = new TableColumn<>("Título");
		TableColumn<Book, String> columYear = new TableColumn<>("Ano");
		TableColumn<Book, String> columCategory = new TableColumn<>("Categoria");

	
		columID.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getId())));
		columTitle.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getTitle())));
		columYear.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getYear())));
		columCategory.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getCategory().getDescription())));
		
	
		
		this.tableView.getColumns().addAll(columID, columTitle, columYear, columCategory);
		
		
		GridPane.setMargin(searchButton, new Insets(10, 10, 10, 10));
		
		add(gridPane, 1, 1);
		add(tableView, 1, 2);
	    GridPane.setHalignment(tableView, HPos.CENTER);
		GridPane.setHgrow(tableView, Priority.ALWAYS);	
	}

}
