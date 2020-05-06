package br.edu.utfpr.adapters.gui.handlers.copies;

import java.time.LocalDate;

import br.edu.utfpr.adapters.gui.views.copies.SaveCopyView;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;
import br.edu.utfpr.libex7.application.ports.in.copies.SaveCopyUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ButtonSaveCopyHandler implements EventHandler<ActionEvent> {
	private final SaveCopyUseCase useCase;
	private final SaveCopyView view;

	public ButtonSaveCopyHandler(SaveCopyUseCase useCase, SaveCopyView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		ComboBox<Book> cmbBook = view.getCmbBook();
	    ComboBox<StatusCopyEnum> cmbStatus = view.getCmbStatus();
	    
	    Book book = cmbBook.getSelectionModel().getSelectedItem();
	    StatusCopyEnum statusCopyEnum = cmbStatus.getSelectionModel().getSelectedItem();
	    
	    TextField txtAcquisitionDate = view.getTxtAcquisitionDate();
	    LocalDate acquisitionDate =  LocalDate.parse(txtAcquisitionDate.getText());

		Copy copy = new Copy();
		copy.setBook(book);
		copy.setStatus(statusCopyEnum);
		copy.setAcquisitionDate(acquisitionDate);
		
		useCase.save(copy);
		Alert alert = new Alert(AlertType.CONFIRMATION, "Exemplar cadastrado com sucesso");
		alert.showAndWait();
		
	}
}