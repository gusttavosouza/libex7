package br.edu.utfpr.adapters.gui.views.copies;

import java.time.format.DateTimeFormatter;

import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import lombok.Getter;


public class SearchCopyView extends Stage {
	
	
	private Scene scene;

	@Getter
	private GridPane root;
	
	private Label lblId = new Label("ID:");
	private Label lblBook = new Label("Livro");
	private Label lblStatus = new Label("Status");
	private Label lblAcquisitionDate = new Label("Data da Aquisição");
	
	@Getter
	private TextField txtID = new TextField();
	
	@Getter
	private TextField txtBook = new TextField();
	

	@Getter
	private ComboBox<StatusCopyEnum> cmbStatus = new ComboBox<>();
	
	@Getter
	private TextField txtAcquisitionDate = new TextField();
	
	@Getter
	private Button searchButton = new Button("Buscar");
	
	@Getter
	private TableView<Copy> tableView = new TableView<>();

	public SearchCopyView() {
		this.setTitle("Consulta Exemplar");
		this.root = new GridPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/copy.png").toExternalForm()));
	}
	
	@SuppressWarnings("unchecked")
	private void init() {
		GridPane gridPane = new GridPane();
		gridPane.add(lblId, 1, 1);
		gridPane.add(txtID, 2, 1);
		gridPane.add(lblBook, 1, 2);
		gridPane.add(txtBook, 2, 2);
		gridPane.add(lblStatus, 1, 3);
		gridPane.add(cmbStatus, 2, 3);
		gridPane.add(lblAcquisitionDate, 1, 4);
		gridPane.add(txtAcquisitionDate, 2, 4);
		gridPane.add(searchButton, 2, 5);
		
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		TableColumn<Copy, String> columID = new TableColumn<>("ID");
		TableColumn<Copy, String> columBook = new TableColumn<>("Livro");
		TableColumn<Copy, String> columStatus = new TableColumn<>("Status");
		TableColumn<Copy, String> columnAcquisitionDate = new TableColumn<>("Data da Aquisição");

	
		columID.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getId())));
		columBook.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getBook().getTitle())));
		columStatus.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getStatus().getDescription())));
		columnAcquisitionDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAcquisitionDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		
	
		
		this.tableView.getColumns().addAll(columID, columBook, columStatus, columnAcquisitionDate);
		
		
		GridPane.setMargin(searchButton, new Insets(10, 10, 10, 10));
		
		this.root.add(gridPane, 1, 1);
		this.root.add(tableView, 1, 2);
	    GridPane.setHalignment(tableView, HPos.CENTER);
		GridPane.setHgrow(tableView, Priority.ALWAYS);	
		
		this.scene = new Scene(root, 700, 500);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}
}
