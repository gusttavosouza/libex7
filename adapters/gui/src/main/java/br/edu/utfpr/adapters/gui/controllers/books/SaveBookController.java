package br.edu.utfpr.adapters.gui.controllers.books;

import java.util.List;

import br.edu.utfpr.adapters.gui.handlers.books.ButtonSaveBookHandler;
import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.in.books.SaveBookUseCase;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lombok.Getter;

@Getter
public class SaveBookController {

	


	private final SaveBookUseCase useCase;
	private final SearchCategoryUseCase searchCategoryUseCase;
	private final SearchAuthorUseCase searchAuthorUseCase;
    private final SaveBookView view;
    
    
    public SaveBookController(SaveBookUseCase useCase, SearchCategoryUseCase searchCategoryUseCase,
			SearchAuthorUseCase searchAuthorUseCase, SaveBookView view) {
		this.useCase = useCase;
		this.searchCategoryUseCase = searchCategoryUseCase;
		this.searchAuthorUseCase = searchAuthorUseCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveBookUseCase useCase, SaveBookView view) {
		
		List<Category> categories = searchCategoryUseCase.findAll();
		List<Author> authors = searchAuthorUseCase.findAll();
		
		ComboBox<Author> cmbAuthor = view.getCmbAuthor();
		cmbAuthor.setItems(FXCollections.observableArrayList(authors));
		cmbAuthor.getSelectionModel().selectFirst();
		
		ComboBox<Category> cmbCategory = view.getCmbCategory();
		cmbCategory.setItems(FXCollections.observableArrayList(categories));
		cmbCategory.getSelectionModel().selectFirst();
		
		Button saveButton = view.getSaveButton();
    	saveButton.setOnAction(new ButtonSaveBookHandler(useCase, view));
	}

    
}
