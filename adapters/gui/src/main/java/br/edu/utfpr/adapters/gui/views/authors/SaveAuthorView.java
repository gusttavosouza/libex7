package br.edu.utfpr.adapters.gui.views.authors;

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

public class SaveAuthorView extends Stage {
	
    private Scene scene;
	
	@Getter
	private BorderPane root;
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblName = new Label("Nome:");
	
	@Getter
	private TextField txtName = new TextField();
	
	public SaveAuthorView() {
		this.setTitle("Novo Autor");
		this.root = new BorderPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/author.png").toExternalForm()));
	}
	
	
	private void init() {
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		gridPane.add(lblName, 1, 1);
		gridPane.add(txtName, 2, 1);
		gridPane.add(saveButton, 2, 2);
		
		HBox hBox = new HBox(gridPane);
		VBox vBox = new VBox(hBox);
		
		GridPane.setHgrow(vBox, Priority.ALWAYS);
		GridPane.setVgrow(vBox, Priority.ALWAYS);
		
		root.setCenter(vBox);
		this.scene = new Scene(root, 500, 80);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}
	

	

}
