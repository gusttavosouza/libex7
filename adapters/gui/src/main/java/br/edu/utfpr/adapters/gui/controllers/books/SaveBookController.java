package br.edu.utfpr.adapters.gui.controllers.books;

import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.books.SaveBookUseCase;
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
    private final SaveBookView view;
    
    
	public SaveBookController(SaveBookUseCase useCase, SaveBookView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveBookUseCase useCase, SaveBookView view) {
		Button saveButton = view.getSaveButton();
    	TextField txtTitle = view.getTxtTitle();
    	TextField txtYear = view.getTxtYear();
		String title = txtTitle.getText().toUpperCase().trim();
		Integer year = NumberUtils.toInt(txtYear.getText());
	    ComboBox<Category> cmbCategory = view.getCmbCategory();
	    Category category = cmbCategory.getValue();
		
		Book book = new Book();
		book.setTitle(title);
		book.setYear(year);
		book.setCategory(category);
		
		
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
