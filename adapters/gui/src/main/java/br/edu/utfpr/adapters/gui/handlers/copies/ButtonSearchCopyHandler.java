package br.edu.utfpr.adapters.gui.handlers.copies;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.edu.utfpr.adapters.gui.views.copies.SearchCopyView;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public  class ButtonSearchCopyHandler implements EventHandler<ActionEvent> {
	
	private final SearchCopyUseCase useCase;
    private final SearchCopyView view;
    
   
	public ButtonSearchCopyHandler(SearchCopyUseCase useCase, SearchCopyView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		
		TextField txtBook = view.getTxtBook();
		 String book = txtBook.getText();
		 
		 if(StringUtils.isEmpty(book)) {
			 List<Copy> books = useCase.findAll();
			 TableView<Copy> tableView = view.getTableView();
			 ObservableList<Copy> observableList = FXCollections.observableArrayList(books);
			 tableView.setItems(observableList);
		 }
		
	}
}