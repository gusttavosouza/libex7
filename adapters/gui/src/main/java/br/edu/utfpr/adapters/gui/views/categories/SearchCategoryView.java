package br.edu.utfpr.adapters.gui.views.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;
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



public class SearchCategoryView extends Stage {
	
	private Scene scene;

	@Getter
	private GridPane root;
	
	
	private Label lblId = new Label("ID:");
	private Label lblDescription = new Label("Descrição:");

	@Getter
	private TextField txtID = new TextField();

	@Getter
	private TextField txtDescription = new TextField();

	@Getter
	private Button searchButton = new Button("Buscar");

	@Getter
	private TableView<Category> tableView = new TableView<>();

	public SearchCategoryView() {
		this.setTitle("Consulta Categoria");
		this.root = new GridPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/category.png").toExternalForm()));
	}

	@SuppressWarnings("unchecked")
	private void init() {

		GridPane gridPane = new GridPane();
		gridPane.add(lblId, 1, 1);
		gridPane.add(txtID, 2, 1);
		gridPane.add(lblDescription, 1, 2);
		gridPane.add(txtDescription, 2, 2);
		gridPane.add(searchButton, 2, 3);

		gridPane.setHgap(10);
		gridPane.setVgap(10);

		TableColumn<Category, String> columID = new TableColumn<>("ID");
		TableColumn<Category, String> columDescription = new TableColumn<>("Descrição");

		columID.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getId())));
		columDescription.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescription()));

		this.tableView.getColumns().addAll(columID, columDescription);

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
