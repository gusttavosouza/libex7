package br.edu.utfpr.adapters.gui.views.checkouts;

import java.time.format.DateTimeFormatter;

import br.edu.utfpr.libex7.application.domain.checkouts.CheckOut;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.domain.users.User;
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
import javafx.util.StringConverter;
import lombok.Getter;

public class SearchCheckOutView extends Stage{
	

	private Scene scene;

	@Getter
	private GridPane root;
	
	private Label lblId = new Label("ID:");
	private Label lblCopy = new Label("Exemplar:");
	private Label lblUser = new Label("Usuário:");
	
	@Getter
	private TextField txtID = new TextField();
	
	@Getter
	private ComboBox<Copy> cmbCopy = new ComboBox<>();
	
	@Getter
	private ComboBox<User> cmbUser = new ComboBox<>();
	
	@Getter
	private Button searchButton = new Button("Buscar");
	
	@Getter
	private TableView<CheckOut> tableView = new TableView<>();

	public SearchCheckOutView() {
		this.setTitle("Consulta Empréstimo");
		this.root = new GridPane();
		init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/checkout.png").toExternalForm()));
	}
	
	@SuppressWarnings("unchecked")
	private void init() {
		
		this.cmbUser.setConverter(new StringConverter<User>() {

			@Override
			public String toString(User user) {
				if(user instanceof Employee) {
					return "(S) - " + user.getId() + " - " + user.getName() + " M: " + ((Employee) user).getEmployeeNumber();
				}else if(user instanceof Student) {
					return "(E) - " + user.getId() + " - " + user.getName() + " RA: " + ((Student) user).getStudentNumber();
				}
				return null;
			}

			@Override
			public User fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		this.cmbCopy.setConverter(new StringConverter<Copy>() {

			@Override
			public String toString(Copy copy) {
				return "(" + copy.getId() + ") - " + copy.getBook().getTitle() + " - " + copy.getBook().getYear();
			}

			@Override
			public Copy fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
		GridPane gridPane = new GridPane();
		gridPane.add(lblId, 1, 1);
		gridPane.add(txtID, 2, 1);
		gridPane.add(lblCopy, 1, 2);
		gridPane.add(cmbCopy, 2, 2);
		gridPane.add(lblUser, 1, 3);
		gridPane.add(cmbUser, 2, 3);
		gridPane.add(searchButton, 2, 4);
		
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		TableColumn<CheckOut, String> columCheckOutDate = new TableColumn<>("Data Empréstimo");
		TableColumn<CheckOut, String> columUser = new TableColumn<>("Usuário");
		TableColumn<CheckOut, String> columExpectedCheckInDate = new TableColumn<>("Data Prevista Devolução");
		

	
		columCheckOutDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCheckOutDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		columUser.setCellValueFactory(cell -> new SimpleStringProperty("("+ cell.getValue().getUser().getId() + ") - " + cell.getValue().getUser().getName()));
		columExpectedCheckInDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getExpectedCheckInDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		
	
		
		this.tableView.getColumns().addAll(columCheckOutDate, columUser, columExpectedCheckInDate);
		
		
		GridPane.setMargin(searchButton, new Insets(10, 10, 10, 10));
		
		this.root.add(gridPane, 1, 1);
		this.root.add(tableView, 1, 2);
	    GridPane.setHalignment(tableView, HPos.CENTER);
		GridPane.setHgrow(tableView, Priority.ALWAYS);	
		
		this.scene = new Scene(root, 700, 500);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}

	


}
