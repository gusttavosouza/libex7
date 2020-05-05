package br.edu.utfpr.adapters.gui.views.commons;


import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import lombok.Getter;
import lombok.Setter;

public class MainView extends BorderPane {
	
	protected MenuBar menuBar;
	
	protected Menu menuHome = new Menu("Home");
	protected Menu menuAuthor = new Menu("Autores");
	protected Menu menuBook = new Menu("Acervo");
	protected Menu menuCheckOut= new Menu("Empréstimo"); 
	protected Menu menuUser= new Menu("Usuários");
	protected Menu menuSearch = new Menu("Busca");
	protected Menu menuExit = new Menu("Sair");
	
	@Getter
	protected MenuItem menuAuthorItem = new MenuItem("Autores");
	
	@Getter
	protected MenuItem menuBookItem = new MenuItem("Livros");

	
	@Getter
	@Setter
	protected Pane root;
	
	public MainView(Pane root) {
		this.root = root;
		init();
	}

	
	private void init () {
		this.menuAuthor.getItems().add(menuAuthorItem);
		this.menuBook.getItems().add(menuBookItem);
		this.menuBar = new MenuBar(menuHome,menuAuthor,menuBook, menuCheckOut, menuUser, menuExit);
		HBox hBox = new HBox(menuBar);
		hBox.setSpacing(10.0);
		hBox.setAlignment(Pos.TOP_RIGHT);
		setAlignment(hBox, Pos.TOP_RIGHT);
		setAlignment(menuBar, Pos.TOP_RIGHT);
		HBox.setHgrow(menuBar, Priority.ALWAYS);
		
		this.setCenter(root);
		GridPane.setHgrow(root,  Priority.ALWAYS);
		GridPane.setVgrow(root,  Priority.ALWAYS);
		this.setTop(hBox);
	}
	
	

}
