package br.edu.utfpr.adapters.gui.views.authors;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class SaveAuthorView extends BorderPane {
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblName = new Label("Nome:");
	
	@Getter
	private TextField txtName = new TextField();
	
	public SaveAuthorView() {
		this.init();
	}
	
	
	private void init() {
		HBox hBox = new HBox(lblName, txtName);
		VBox vBox = new VBox(hBox, saveButton);
		setCenter(vBox);
	}
	

	

}
