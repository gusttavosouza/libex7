package br.edu.utfpr.adapters.gui.views.users.employees;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class SaveEmployeeView extends BorderPane {
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblName = new Label("Nome:");
	
	@Getter	
	private Label lblDob = new Label("Data de Nascimento:");
	
	@Getter	
	private Label lblEmployeeNumber= new Label("Matrícula:");
	
	@Getter
	private TextField txtName = new TextField();
	
	@Getter
	private TextField txtDob = new TextField();
	
	@Getter
	private TextField txtEmployeeNumber = new TextField();
	
	public SaveEmployeeView() {
		this.init();
	}
	
	
	private void init() {
		HBox hBoxName = new HBox(lblName, txtName);
		HBox hBoxDob = new HBox(lblDob, txtDob);
		HBox hBoxStudentNumber = new HBox(lblEmployeeNumber, txtEmployeeNumber);
		VBox vBox = new VBox(hBoxName, hBoxDob,hBoxStudentNumber, saveButton);
		setCenter(vBox);
	}
	

	

}
