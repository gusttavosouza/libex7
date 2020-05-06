package br.edu.utfpr.adapters.gui.handlers.books;

import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.books.SaveBookView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.books.SaveBookUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ButtonSaveBookHandler implements EventHandler<ActionEvent> {
	
	
	private final SaveBookUseCase useCase;
	private final SaveBookView view;

	public ButtonSaveBookHandler(SaveBookUseCase useCase, SaveBookView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			
			ComboBox<Author> cmbAuthor = view.getCmbAuthor();
			ComboBox<Category> cmbCategory = view.getCmbCategory();
			
			Author author = cmbAuthor.getSelectionModel().getSelectedItem();
		    Category category = cmbCategory.getSelectionModel().getSelectedItem();
		    
		    TextField txtTitle = view.getTxtTitle();
	    	TextField txtYear = view.getTxtYear();
			String title = txtTitle.getText().toUpperCase().trim();
			Integer year = NumberUtils.toInt(txtYear.getText());
			
			Book book = new Book();
			book.setTitle(title);
			book.setYear(year);
			book.setCategory(category);
			book.addAuthor(author);
			useCase.save(book);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Livro cadastrado com sucesso");
			alert.showAndWait();
		}catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar livro");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
}