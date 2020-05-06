package br.edu.utfpr.adapters.gui.controllers.books;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.in.books.SaveBookUseCase;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
		cmbAuthor.getItems().addAll(authors);
		
		ComboBox<Category> cmbCategory = view.getCmbCategory();
		cmbCategory.getItems().addAll(categories);
		
		Button saveButton = view.getSaveButton();
    	TextField txtTitle = view.getTxtTitle();
    	TextField txtYear = view.getTxtYear();
		String title = txtTitle.getText().toUpperCase().trim();
		Integer year = NumberUtils.toInt(txtYear.getText());
		
		Author author = cmbAuthor.getSelectionModel().getSelectedItem();
	    Category category = cmbCategory.getSelectionModel().getSelectedItem();
		
		Book book = new Book();
		book.setTitle(title);
		book.setYear(year);
		book.setCategory(category);
		book.addAuthor(author);
		
		
		
		
    	saveButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				useCase.save(book);
				Alert alert = new Alert(AlertType.CONFIRMATION, "Livro cadastrado com sucesso");
				alert.showAndWait();
				
			}
		});
	}





	

    
  
    
}
