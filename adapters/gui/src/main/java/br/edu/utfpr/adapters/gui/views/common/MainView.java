package br.edu.utfpr.adapters.gui.views.common;

import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class MainView extends BorderPane {
	
	protected MenuBar menuBar;
	protected Menu menuHome = new Menu("Home");
	protected Menu menuAuthor = new Menu("Autores");
	protected Menu menuBook = new Menu("Acervo");
	protected Menu menuCheckOut= new Menu("Empréstimo"); 
	protected Menu menuUser= new Menu("Usuários");
	protected Menu menuSearch = new Menu("Busca");
	protected Parent root;
	
	public MainView(Parent root) {
		this.root = root;
		init();
	}

	
	private void init () {
		this.menuBar = new MenuBar(menuHome,menuAuthor,menuBook, menuCheckOut, menuUser);
		HBox hBox = new HBox(menuBar);
		HBox.setHgrow(menuBar, Priority.ALWAYS);
		this.setCenter(root);
		this.setTop(hBox);
	}

}
