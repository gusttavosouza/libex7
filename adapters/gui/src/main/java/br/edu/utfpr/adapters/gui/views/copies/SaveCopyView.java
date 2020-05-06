package br.edu.utfpr.adapters.gui.views.copies;

import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class SaveCopyView extends Stage {
	
private Scene scene;
	
	@Getter
	private BorderPane root;
	
	@Getter
	private Button saveButton = new Button("Salvar");
	
	@Getter	
	private Label lblBook = new Label("Livro:");
	
	
	@Getter	
	private ComboBox<Book> cmbBook = new ComboBox<>();


	@Getter	
	private Label lblAcquisitionDate = new Label("Data da Aquisição:");
	
	@Getter
	private TextField txtAcquisitionDate = new TextField();
	
	
	@Getter	
	private Label lblStatus = new Label("Status:");
	
	
	
	@Getter	
	private ComboBox<StatusCopyEnum> cmbStatus = new ComboBox<>();
	
	
	public SaveCopyView() {
		this.setTitle("Novo Exemplar");
		this.root = new BorderPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/copy.png").toExternalForm()));
	}
	
	
	private void init() {
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		gridPane.add(lblBook, 1, 1);
		gridPane.add(cmbBook, 2, 1);
		gridPane.add(lblStatus, 1, 2);
		gridPane.add(cmbStatus, 2, 2);
		gridPane.add(lblAcquisitionDate, 1, 3);
		gridPane.add(txtAcquisitionDate, 2, 3);
		gridPane.add(saveButton, 2, 4);
		
		HBox hBox = new HBox(gridPane);
		VBox vBox = new VBox(hBox);
		
		GridPane.setHgrow(vBox, Priority.ALWAYS);
		GridPane.setVgrow(vBox, Priority.ALWAYS);
		
		root.setCenter(vBox);
		this.scene = new Scene(root, 500, 80);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}
	

	

}
