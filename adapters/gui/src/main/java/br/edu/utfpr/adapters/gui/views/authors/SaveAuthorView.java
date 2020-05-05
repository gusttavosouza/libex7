package br.edu.utfpr.adapters.gui.views.authors;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SaveAuthorView extends BorderPane {
	
	private Button saveButton = new Button("Salvar");
	private Label lblName = new Label("Nome:");
	private TextField txtName = new TextField();
	
	public SaveAuthorView() {
		this.init();
	}
	
	
	private void init() {
		HBox hBox = new HBox(lblName, txtName);
		VBox vBox = new VBox(hBox, saveButton);
		setCenter(vBox);
	}
	
	public Button getSaveButton() {
		return saveButton;
	}
	

}
