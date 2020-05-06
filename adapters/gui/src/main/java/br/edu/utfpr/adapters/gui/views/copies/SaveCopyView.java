package br.edu.utfpr.adapters.gui.views.copies;

import br.edu.utfpr.libex7.application.domain.categories.Category;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class SaveCopyView extends BorderPane {
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblTitle = new Label("Título:");
	
	@Getter	
	private Label lblYear = new Label("Ano:");
	
	@Getter	
	private Label lblCategory = new Label("Categoria:");
	
	@Getter
	private TextField txtTitle = new TextField();
	
	@Getter
	private TextField txtYear = new TextField();
	
	@Getter
	private ComboBox<Category> cmbCategory = new ComboBox<>();
	
	public SaveCopyView() {
		this.init();
	}
	
	
	private void init() {
		HBox hBoxTitle = new HBox(lblTitle, txtTitle);
		HBox hBoxYear = new HBox(lblYear, txtYear);
		HBox hBoxCategory = new HBox(lblCategory, cmbCategory);
		VBox vBox = new VBox(hBoxTitle,hBoxYear,hBoxCategory, saveButton);
		setCenter(vBox);
	}
	

	

}
