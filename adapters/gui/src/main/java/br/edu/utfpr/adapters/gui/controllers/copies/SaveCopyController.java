package br.edu.utfpr.adapters.gui.controllers.copies;

import org.apache.commons.lang3.math.NumberUtils;

import br.edu.utfpr.adapters.gui.views.copies.SaveCopyView;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;
import br.edu.utfpr.libex7.application.ports.in.copies.SaveCopyUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SaveCopyController {

	private final SaveCopyUseCase useCase;
    private final SaveCopyView view;
    
    
	public SaveCopyController(SaveCopyUseCase useCase, SaveCopyView view) {
		this.useCase = useCase;
		this.view = view;
		init(useCase, view);
	}


	private void init(SaveCopyUseCase useCase, SaveCopyView view) {
		Button saveButton = view.getSaveButton();
    	TextField txtTitle = view.getTxtTitle();
    	TextField txtYear = view.getTxtYear();
		String title = txtTitle.getText().toUpperCase().trim();
		Integer year = NumberUtils.toInt(txtYear.getText());
	    ComboBox<Category> cmbCategory = view.getCmbCategory();
	    Category category = cmbCategory.getValue();
		
		Copy book = new Copy();
		book.setBook(null);
		book.setStatus(StatusCopyEnum.AVAILABLE);
		
		
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
