package br.edu.utfpr.adapters.gui.views.users.students;

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

public class SaveStudentView extends Stage {
	
	 private Scene scene;
		
	@Getter
    private BorderPane root;
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblName = new Label("Nome:");
	
	@Getter	
	private Label lblDob = new Label("Data de Nascimento:");
	
	@Getter	
	private Label lblDobFormat = new Label("dd/mm/aaaa");
	
	@Getter	
	private Label lblStudentNumber= new Label("RA:");
	
	@Getter
	private TextField txtName = new TextField();
	
	@Getter
	private TextField txtDob = new TextField();
	
	@Getter
	private TextField txtStudentNumber = new TextField();
	
	public SaveStudentView() {
		this.setTitle("Novo Estudante");
		this.root = new BorderPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/user.png").toExternalForm()));
	}
	
	
	private void init() {

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		gridPane.add(lblName, 1, 1);
		gridPane.add(txtName, 2, 1);
		gridPane.add(lblDob, 1, 2);
		gridPane.add(txtDob, 2, 2);
		gridPane.add(lblDobFormat, 3, 2);
		gridPane.add(lblStudentNumber, 1, 3);
		gridPane.add(txtStudentNumber, 2, 3);
		gridPane.add(saveButton, 2, 4);
		
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
