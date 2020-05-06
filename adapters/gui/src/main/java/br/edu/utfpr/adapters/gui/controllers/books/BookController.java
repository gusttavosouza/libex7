package br.edu.utfpr.adapters.gui.controllers.books;

import lombok.Getter;


@Getter
public class BookController {
	
	private final SaveBookController saveBookController;
	private final SearchBookController searchBookController;
	

	public BookController(SaveBookController saveBookController, SearchBookController searchBookController) {
		this.saveBookController = saveBookController;
		this.searchBookController = searchBookController;
	}

}
