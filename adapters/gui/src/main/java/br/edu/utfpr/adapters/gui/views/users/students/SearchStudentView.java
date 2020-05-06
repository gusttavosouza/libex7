package br.edu.utfpr.adapters.gui.views.users.students;

import br.edu.utfpr.libex7.application.domain.users.Student;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import lombok.Getter;

@Getter
public class SearchStudentView extends GridPane {
	
	
	private Label lblId = new Label("ID:");
	private Label lblName = new Label("Nome:");
	private TextField txtID = new TextField("ID:");
	private TextField txtName = new TextField("Nome:");
	private Button searchButton = new Button("Buscar");
	private ListView<Student> listView = new ListView<>();

	public SearchStudentView() {
	    init();	
	}
	
	private void init() {
		add(lblId, 1, 1);
		add(txtID, 2, 1);
		add(lblName, 1, 2);
		add(txtName, 2, 2);
		add(searchButton, 2, 3);
		addRow(4, listView);
	}

}
