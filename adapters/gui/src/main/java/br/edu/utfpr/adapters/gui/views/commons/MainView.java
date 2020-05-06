package br.edu.utfpr.adapters.gui.views.commons;




import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class MainView extends Stage {
	
	protected MenuBar menuBar;
	protected Menu menuHome = new Menu("Home");
	protected Menu menuAuthor = new Menu("Autores");
	protected Menu menuBook = new Menu("Acervo");
	protected Menu menuCategory = new Menu("Categorias");
	protected Menu menuCheckOut= new Menu("Empréstimos"); 
	protected Menu menuUser= new Menu("Usuários");
	protected Menu menuSearch = new Menu("Busca");
	protected Menu menuExit = new Menu("Sair");
	

	private Scene scene;
	
	@Getter
	private BorderPane root;
	
	@Getter
	protected MenuItem menuItemNewAuthor = new MenuItem("Novo");
	
	
	@Getter
	protected MenuItem menuItemSearchAuthor = new MenuItem("Buscar");
	
	
	@Getter
	protected MenuItem menuItemNewBook = new MenuItem("Novo");
	
	
	@Getter
	protected MenuItem menuItemSearchBook = new MenuItem("Buscar");
	
	
	@Getter
	protected MenuItem menuItemNewCategory = new MenuItem("Novo");
	
	
	@Getter
	protected MenuItem menuItemSearchCategory = new MenuItem("Buscar");
	
	
	@Getter
	protected MenuItem menuItemNewCheckout = new MenuItem("Novo");
	
	
	@Getter
	protected MenuItem menuItemSearchCheckout = new MenuItem("Buscar");
	
	@Getter
	protected MenuItem menuItemNewStudent = new MenuItem("Novo Estudante");
	
	
	@Getter
	protected MenuItem menuItemSearchStudent = new MenuItem("Buscar Estudante");
	
	@Getter
	protected MenuItem menuItemNewSEmployee = new MenuItem("Novo Servidor");
	
	
	@Getter
	protected MenuItem menuItemSearchEmplyee = new MenuItem("Buscar Servidor");
	
	
	@Getter
	@Setter
	protected Pane content;
	
	public MainView(Pane root) {
		this.setTitle("Biblioteca Libex7");
		this.content = root;
		this.root = new BorderPane();
		init();
		this.setMaximized(true);
		this.setScene(scene);
	}

	
	private void init () {
		this.menuAuthor.getItems().addAll(menuItemNewAuthor, menuItemSearchAuthor);
		this.menuBook.getItems().addAll(menuItemNewBook, menuItemSearchBook);
		this.menuCategory.getItems().addAll(menuItemNewCategory, menuItemSearchCategory);
		this.menuCheckOut.getItems().addAll(menuItemNewCheckout, menuItemSearchCheckout);
		this.menuUser.getItems().addAll(menuItemNewStudent, menuItemSearchStudent, menuItemNewSEmployee, menuItemSearchEmplyee);
		
		
		
		this.menuBar = new MenuBar(menuHome,menuAuthor,menuBook, menuCheckOut, menuUser, menuExit);
		HBox hBox = new HBox(menuBar);
		hBox.setSpacing(10.0);
		hBox.setAlignment(Pos.TOP_RIGHT);
		BorderPane.setAlignment(hBox, Pos.TOP_RIGHT);
		BorderPane.setAlignment(menuBar, Pos.TOP_RIGHT);
		HBox.setHgrow(menuBar, Priority.ALWAYS);
		
	
		root.setCenter(content);
		GridPane.setHgrow(content,  Priority.ALWAYS);
		GridPane.setVgrow(content,  Priority.ALWAYS);
		root.setTop(hBox);
		this.scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}
	
	

}
