package br.edu.utfpr.adapters.gui.views.categories;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class SaveCategoryView extends BorderPane {
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblDescription = new Label("Descrição:");
	
	@Getter
	private TextField txtDescription = new TextField();
	
	public SaveCategoryView() {
		this.init();
	}
	
	
	private void init() {
		HBox hBox = new HBox(lblDescription, txtDescription);
		VBox vBox = new VBox(hBox, saveButton);
		setCenter(vBox);
	}
	

	

}
