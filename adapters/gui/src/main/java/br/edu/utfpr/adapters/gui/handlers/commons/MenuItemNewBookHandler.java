package br.edu.utfpr.adapters.gui.handlers.commons;

import java.util.List;

import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.books.SaveBookController;
import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MenuItemNewBookHandler implements EventHandler<ActionEvent> {
	private final BookController bookController;
	private final SearchAuthorUseCase searchAuthorUseCase;
	private final SearchCategoryUseCase searchCategoryUseCase;

	public MenuItemNewBookHandler(BookController bookController, SearchAuthorUseCase searchAuthorUseCase, SearchCategoryUseCase searchCategoryUseCase) {
		this.bookController = bookController;
		this.searchAuthorUseCase = searchAuthorUseCase;
		this.searchCategoryUseCase = searchCategoryUseCase;
	}

	@Override
	public void handle(ActionEvent event) {
		SaveBookController saveBookController = bookController.getSaveBookController();
		SaveBookView saveBookView = saveBookController.getView();
		TextField txtTitle = saveBookView.getTxtTitle();
		TextField txtYear = saveBookView.getTxtYear();
		
		
		txtTitle.clear();
		txtYear.clear();
		
		List<Author> authors = searchAuthorUseCase.findAll();
		List<Category> categories = searchCategoryUseCase.findAll();
		
		
		ComboBox<Author> cmbAuthor = saveBookView.getCmbAuthor();
		cmbAuthor.getItems().clear();
		cmbAuthor.setItems(FXCollections.observableArrayList(authors));
		cmbAuthor.getSelectionModel().selectFirst();
		
		ComboBox<Category> cmbCategory = saveBookView.getCmbCategory();
		cmbCategory.getItems().clear();
		cmbCategory.setItems(FXCollections.observableArrayList(categories));
		cmbCategory.getSelectionModel().selectFirst();
		
		
		
		saveBookView.show();

	}
}