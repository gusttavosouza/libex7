package br.edu.utfpr.adapters.gui.views.authors;

import br.edu.utfpr.libex7.application.domain.authors.Author;
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

public class SearchAuthorView extends Stage {

	private Scene scene;

	@Getter
	private GridPane root;

	private Label lblId = new Label("ID:");
	private Label lblName = new Label("Nome:");

	@Getter
	private TextField txtID = new TextField();

	@Getter
	private TextField txtName = new TextField();

	@Getter
	private Button searchButton = new Button("Buscar");

	@Getter
	private TableView<Author> tableView = new TableView<>();

	public SearchAuthorView() {
		this.setTitle("Consulta Autor");
		this.root = new GridPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/author.png").toExternalForm()));
	}

	@SuppressWarnings("unchecked")
	private void init() {

		GridPane gridPane = new GridPane();
		gridPane.add(lblId, 1, 1);
		gridPane.add(txtID, 2, 1);
		gridPane.add(lblName, 1, 2);
		gridPane.add(txtName, 2, 2);
		gridPane.add(searchButton, 2, 3);

		gridPane.setHgap(10);
		gridPane.setVgap(10);

		TableColumn<Author, String> columID = new TableColumn<>("ID");
		TableColumn<Author, String> columName = new TableColumn<>("Nome");

		columID.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getId())));
		columName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));

		this.tableView.getColumns().addAll(columID, columName);

		GridPane.setMargin(searchButton, new Insets(10, 10, 10, 10));

		root.add(gridPane, 1, 1);
		root.add(tableView, 1, 2);
		GridPane.setHalignment(tableView, HPos.CENTER);
		GridPane.setHgrow(tableView, Priority.ALWAYS);
		GridPane.setVgrow(tableView, Priority.ALWAYS);
		this.scene = new Scene(root, 700, 500);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}

}
