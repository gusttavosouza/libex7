package br.edu.utfpr.adapters.gui.views.books;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.categories.Category;
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

public class SaveBookView extends Stage {

	private Scene scene;

	@Getter
	private BorderPane root;

	@Getter
	private Button saveButton = new Button("Salvar");

	@Getter
	private Label lblTitle = new Label("Título:");

	@Getter
	private Label lblYear = new Label("Ano:");

	@Getter
	private Label lblCategory = new Label("Categoria:");

	@Getter
	private Label lblAuthor = new Label("Autor:");

	@Getter
	private TextField txtTitle = new TextField();

	@Getter
	private TextField txtYear = new TextField();

	@Getter
	private ComboBox<Category> cmbCategory = new ComboBox<>();

	@Getter
	private ComboBox<Author> cmbAuthor = new ComboBox<>();

	public SaveBookView() {
		this.setTitle("Novo Livro");
		this.root = new BorderPane();
		this.init();
		this.setScene(scene);
		this.getIcons().add(new Image(getClass().getResource("/images/book.png").toExternalForm()));
	}

	private void init() {

		this.cmbAuthor.setConverter(new StringConverter<Author>() {

			@Override
			public String toString(Author author) {
				return author.getId() + "-" + author.getName();
			}

			@Override
			public Author fromString(String author) {
				return null;
			}
		});

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(lblTitle, 1, 1);
		gridPane.add(txtTitle, 2, 1);
		gridPane.add(lblYear, 1, 2);
		gridPane.add(txtYear, 2, 2);
		gridPane.add(lblCategory, 1, 3);
		gridPane.add(cmbCategory, 2, 3);
		gridPane.add(lblAuthor, 1, 4);
		gridPane.add(cmbAuthor, 2, 4);
		gridPane.add(saveButton, 2, 5);

		HBox hBox = new HBox(gridPane);
		VBox vBox = new VBox(hBox);
		
		root.setCenter(vBox);
		this.scene = new Scene(root, 500, 300);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}

}
