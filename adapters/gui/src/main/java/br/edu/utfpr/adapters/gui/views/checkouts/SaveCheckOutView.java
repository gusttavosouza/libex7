package br.edu.utfpr.adapters.gui.views.checkouts;



import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.domain.users.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lombok.Getter;

public class SaveCheckOutView extends Stage {

	private Scene scene;

	@Getter
	private BorderPane root;

	@Getter
	private Button saveButton = new Button("Salvar");

	@Getter
	private Label lblUser = new Label("Usu�rio:");

	@Getter
	private Label lblCopy = new Label("Exemplar:");

	@Getter
	private Label lblExpectedCheckInDate = new Label("Data Prevista Devolução:");
	
	@Getter
	private Label lblExpectedCheckInDateFormat = new Label("dd/mm/aaaa");

	@Getter
	private Label lblCheckInDate = new Label("Data Devolução:");
	
	@Getter
	private Label lblCheckInDateFormat = new Label("dd/mm/aaaa");

	@Getter
	private ComboBox<User> cmbUser = new ComboBox<>();

	@Getter
	private ComboBox<Copy> cmbCopy = new ComboBox<>();
	
	@Getter
	private TextField txtExpectedCheckInDate = new TextField();
	
	@Getter
	private TextField txtCheckInDate = new TextField();

	public SaveCheckOutView() {
		this.setTitle("Novo Empr�stimo");
		this.root = new BorderPane();
		this.init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/checkout.png").toExternalForm()));
	}

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
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(lblUser, 1, 1);
		gridPane.add(cmbUser, 2, 1);
		gridPane.add(lblCopy, 1, 2);
		gridPane.add(cmbCopy, 2, 2);
		gridPane.add(lblExpectedCheckInDate, 1, 3);
		gridPane.add(txtExpectedCheckInDate, 2, 3);
		gridPane.add(lblExpectedCheckInDateFormat, 3, 3);
		gridPane.add(lblCheckInDate, 1, 4);
		gridPane.add(txtCheckInDate, 2, 4);
		gridPane.add(lblCheckInDateFormat, 3, 4);
		
		gridPane.add(saveButton, 2, 5);

		HBox hBox = new HBox(gridPane);
		VBox vBox = new VBox(hBox);
		
		VBox.setMargin(hBox, new Insets(10, 10, 10, 10));

		root.setCenter(vBox);
		this.scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}

}
