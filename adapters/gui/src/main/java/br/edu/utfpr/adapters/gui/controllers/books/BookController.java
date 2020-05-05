package br.edu.utfpr.adapters.gui.controllers.books;

import br.edu.utfpr.adapters.gui.views.books.BookView;
import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import lombok.Getter;


public class BookController {
	
	private final SaveBookController saveBookController;
	private final SearchBookController searchBookController;
	
	@Getter
	private BookView bookView;
	
	
	public BookController(SaveBookController saveBookController, SearchBookController searchBookController) {
		this.saveBookController = saveBookController;
		this.searchBookController = searchBookController;
		SaveBookView saveBookView = this.saveBookController.getView();
		SearchBookView searchBookView = this.searchBookController.getView();
		this.bookView = new BookView(saveBookView, searchBookView);
	}


	
	

}
