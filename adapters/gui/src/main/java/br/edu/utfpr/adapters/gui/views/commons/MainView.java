package br.edu.utfpr.adapters.gui.views.commons;




import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
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
	protected Menu menuCopy= new Menu("Exemplares"); 
	protected Menu menuCheckOut= new Menu("Empéstimos"); 
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
	protected MenuItem menuItemNewCopy = new MenuItem("Novo");
	
	
	@Getter
	protected MenuItem menuItemSearchCopy = new MenuItem("Buscar");
	
	
	@Getter
	protected MenuItem menuItemNewCheckout = new MenuItem("Novo");
	
	
	@Getter
	protected MenuItem menuItemSearchCheckout = new MenuItem("Buscar");
	
	@Getter
	protected MenuItem menuItemNewStudent = new MenuItem("Novo Estudante");
	
	
	@Getter
	protected MenuItem menuItemSearchStudent = new MenuItem("Buscar Estudante");
	
	@Getter
	protected MenuItem menuItemNewEmployee = new MenuItem("Novo Servidor");
	
	
	@Getter
	protected MenuItem menuItemSearchEmployee = new MenuItem("Buscar Servidor");
	
	@Getter
	protected MenuItem menuItemExit = new MenuItem("Sair");
	
	
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
		this.getIcons().add(new Image(getClass().getResource("/images/logo.png").toExternalForm()));
	}

	
	private void init () {
		this.menuAuthor.getItems().addAll(menuItemNewAuthor, menuItemSearchAuthor);
		this.menuBook.getItems().addAll(menuItemNewBook, menuItemSearchBook);
		this.menuCategory.getItems().addAll(menuItemNewCategory, menuItemSearchCategory);
		this.menuCopy.getItems().addAll(menuItemNewCopy, menuItemSearchCopy);
		this.menuCheckOut.getItems().addAll(menuItemNewCheckout, menuItemSearchCheckout);
		this.menuUser.getItems().addAll(menuItemNewStudent, menuItemSearchStudent, menuItemNewEmployee, menuItemSearchEmployee);
		this.menuExit.getItems().addAll(menuItemExit);
		
		
		this.menuBar = new MenuBar(menuHome,menuAuthor,menuBook,menuCategory,menuCopy, menuCheckOut, menuUser, menuExit);
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
