package br.edu.utfpr.adapters.gui.configuration.commons;

import br.edu.utfpr.adapters.gui.configuration.authors.AuthorConfiguration;
import br.edu.utfpr.adapters.gui.configuration.books.BookConfiguration;
import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.commons.MainController;
import br.edu.utfpr.adapters.gui.views.commons.MainView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainConfiguration {
	
	private final MainView view;

	public MainController configure() {
		  AuthorConfiguration authorConfiguration = new AuthorConfiguration();
		  AuthorController authorController = authorConfiguration.configure();
		  
		  BookConfiguration bookConfiguration = new BookConfiguration();
		  BookController bookController = bookConfiguration.configure();
		  return new MainController(view, authorController, bookController);
	}

}
