package br.edu.utfpr.adapters.gui.handlers.commons;

import java.util.List;

import br.edu.utfpr.adapters.gui.controllers.copies.CopyController;
import br.edu.utfpr.adapters.gui.controllers.copies.SaveCopyController;
import br.edu.utfpr.adapters.gui.views.copies.SaveCopyView;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public final class MenuItemNewCopyHandler implements EventHandler<ActionEvent> {
	
	private final CopyController copyController;
	private final SearchBookUseCase searchBookUseCase;

	public MenuItemNewCopyHandler(CopyController copyController, SearchBookUseCase searchBookUseCase) {
		this.copyController = copyController;
		this.searchBookUseCase = searchBookUseCase;
	}

	@Override
	public void handle(ActionEvent event) {
	     SaveCopyController saveCopyController = copyController.getSaveCopyController();
	     SaveCopyView saveCopyView = saveCopyController.getView();
	     
	     ComboBox<Book> cmbBook = saveCopyView.getCmbBook();
	     ComboBox<StatusCopyEnum> cmbStatus = saveCopyView.getCmbStatus();
	     
	     List<Book> books = searchBookUseCase.findAll();
	     
	     cmbBook.getItems().clear();
	     cmbBook.getItems().setAll(FXCollections.observableArrayList(books));
	     
	     cmbStatus.getItems().clear();
	     cmbStatus.getItems().setAll(FXCollections.observableArrayList(StatusCopyEnum.values()));
	     
	     
	     
	     TextField txtAcquisitionDate = saveCopyView.getTxtAcquisitionDate();
	     txtAcquisitionDate.clear();
	     
	     saveCopyView.show();
	}
}