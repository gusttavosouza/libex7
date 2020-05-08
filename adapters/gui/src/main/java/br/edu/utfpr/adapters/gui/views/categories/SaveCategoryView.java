package br.edu.utfpr.adapters.gui.views.categories;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;

public class SaveCategoryView extends Stage {

	private Scene scene;

	@Getter
	private BorderPane root;

	@Getter
	private Button saveButton = new Button("Salvar");

	@Getter
	private Label lblDescription = new Label("Descrição:");

	@Getter
	private TextField txtDescription = new TextField();

	public SaveCategoryView() {
		this.setTitle("Nova Categoria");
		this.root = new BorderPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/category.png").toExternalForm()));
	}

	private void init() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		gridPane.add(lblDescription, 1, 1);
		gridPane.add(txtDescription, 2, 1);
		gridPane.add(saveButton, 2, 2);
		
		HBox hBox = new HBox(gridPane);
		VBox vBox = new VBox(hBox);
		
		VBox.setMargin(hBox, new Insets(10, 10, 10, 10));
		
		GridPane.setHgrow(vBox, Priority.ALWAYS);
		GridPane.setVgrow(vBox, Priority.ALWAYS);
		
		root.setCenter(vBox);
		this.scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}

}
