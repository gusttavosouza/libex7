package br.edu.utfpr.adapters.gui.controllers.commons;

import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.authors.SaveAuthorController;
import br.edu.utfpr.adapters.gui.controllers.authors.SearchAuthorController;
import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.books.SaveBookController;
import br.edu.utfpr.adapters.gui.controllers.books.SearchBookController;
import br.edu.utfpr.adapters.gui.views.authors.SaveAuthorView;
import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import br.edu.utfpr.adapters.gui.views.commons.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
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

		MenuItem menuItemNewAuthor = this.view.getMenuItemNewAuthor();
		menuItemNewAuthor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SaveAuthorController saveAuthorController = authorController.getSaveAuthorController();
				SaveAuthorView saveAuthorView = saveAuthorController.getView();

				Scene scene = new Scene(saveAuthorView, 500, 100);

				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
			}
		});

		MenuItem menuItemSearchAuthor = this.view.getMenuItemSearchAuthor();
		menuItemSearchAuthor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SearchAuthorController searchAuthorController = authorController.getSearchAuthorController();
				SearchAuthorView searchAuthorView = searchAuthorController.getView();

				Scene scene = new Scene(searchAuthorView, 700, 500);

				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
			}
		});

		MenuItem menuItemNewBook = this.view.getMenuItemNewBook();
		menuItemNewBook.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SaveBookController saveBookController = bookController.getSaveBookController();
				SaveBookView saveBookView = saveBookController.getView();

				Scene scene = new Scene(saveBookView, 700, 500);

				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();

			}
		});

		MenuItem menuItemSearchBook = this.view.getMenuItemSearchBook();
		menuItemSearchBook.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SearchBookController searchBookController = bookController.getSearchBookController();
				SearchBookView searchBookView = searchBookController.getView();

				Scene scene = new Scene(searchBookView, 700, 500);

				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();

			}
		});

	}

}
