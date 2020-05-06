package br.edu.utfpr.adapters.gui.views.users.students;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class SaveStudentView extends BorderPane {
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblName = new Label("Nome:");
	
	@Getter	
	private Label lblDob = new Label("Data de Nascimento:");
	
	@Getter	
	private Label lblStudentNumber= new Label("RA:");
	
	@Getter
	private TextField txtName = new TextField();
	
	@Getter
	private TextField txtDob = new TextField();
	
	@Getter
	private TextField txtStudentNumber = new TextField();
	
	public SaveStudentView() {
		this.init();
	}
	
	
	private void init() {
		HBox hBoxName = new HBox(lblName, txtName);
		HBox hBoxDob = new HBox(lblDob, txtDob);
		HBox hBoxStudentNumber = new HBox(lblStudentNumber, txtStudentNumber);
		VBox vBox = new VBox(hBoxName, hBoxDob,hBoxStudentNumber, saveButton);
		setCenter(vBox);
	}
	

	

}
