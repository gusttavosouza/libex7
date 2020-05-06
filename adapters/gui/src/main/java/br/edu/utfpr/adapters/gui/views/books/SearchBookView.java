package br.edu.utfpr.adapters.gui.views.books;

import br.edu.utfpr.libex7.application.domain.books.Book;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import lombok.Getter;


public class SearchBookView extends Stage {
	

	private Scene scene;

	@Getter
	private GridPane root;
	
	private Label lblId = new Label("ID:");
	private Label lblTitle = new Label("Título");
	private Label lblAuthorName = new Label("Autor");
	
	@Getter
	private TextField txtID = new TextField();
	
	@Getter
	private TextField txtTitle = new TextField();
	
	@Getter
	private TextField txtAuthorName = new TextField();
	
	@Getter
	private Button searchButton = new Button("Buscar");
	
	@Getter
	private TableView<Book> tableView = new TableView<>();

	public SearchBookView() {
		this.setTitle("Consulta Acervo");
		this.root = new GridPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/book.png").toExternalForm()));
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
		gridPane.add(searchButton, 2, 4);
		
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
		
		this.root.add(gridPane, 1, 1);
		this.root.add(tableView, 1, 2);
	    GridPane.setHalignment(tableView, HPos.CENTER);
		GridPane.setHgrow(tableView, Priority.ALWAYS);	
		
		this.scene = new Scene(root, 700, 500);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}

}
