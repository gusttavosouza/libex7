package br.edu.utfpr.adapters.gui.controllers.commons;



import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.views.authors.AuthorView;
import br.edu.utfpr.adapters.gui.views.books.BookView;
import br.edu.utfpr.adapters.gui.views.commons.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import lombok.Getter;

@Getter
public class MainController {

	private final MainView view;
	private final AuthorController authorController;
	private final BookController bookController;

	public MainController(MainView view, AuthorController authorController, BookController bookController) {
		this.view = view;
		this.authorController = authorController;
		this.bookController = bookController;

		MenuItem menuAuthorItem = this.view.getMenuAuthorItem();
		menuAuthorItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Pane root = (Pane) view.getRoot();
				root.getChildren().clear();
				
	
				AuthorView authorView = authorController.getAuthorView();
				
				view.setCenter(authorView);
				GridPane.setHgrow(authorView,  Priority.ALWAYS);
				GridPane.setVgrow(authorView,  Priority.ALWAYS);
				
			
			
				
				root.getChildren().setAll(authorView);
			}
		});
		
		
		MenuItem menuBookItem = this.view.getMenuBookItem();
		menuBookItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
		        BookView bookView = bookController.getBookView();
				Pane root = (Pane) view.getRoot();
				AnchorPane.setTopAnchor(root, 0.0);
				AnchorPane.setRightAnchor(root, 0.0);
				AnchorPane.setLeftAnchor(root, 0.0);
				AnchorPane.setBottomAnchor(root, 0.0);
				root.getChildren().setAll(bookView);
			}
		});

	}

}
