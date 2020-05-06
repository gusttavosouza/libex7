package br.edu.utfpr.adapters.gui.handlers.authors;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



public class ButtonSearchAuthorHandler implements EventHandler<ActionEvent> {
	
	private final SearchAuthorView view;
	private final SearchAuthorUseCase useCase;

	public ButtonSearchAuthorHandler(SearchAuthorView view, SearchAuthorUseCase useCase) {
		this.view = view;
		this.useCase = useCase;
	}
	
	@Override
	public void handle(ActionEvent event) {
		 TextField txtName = view.getTxtName();
		 String name = txtName.getText();
		 
		 if(name != null && !name.isEmpty()) {
			 List<Author> authors = useCase.findByName(name);
		     TableView<Author> tableView = view.getTableView();
			 ObservableList<Author> observableList = FXCollections.observableArrayList(authors);
			 tableView.setItems(observableList);
		 }else {
			 List<Author> authors = useCase.findAll();
			 TableView<Author> tableView = view.getTableView();
			 ObservableList<Author> observableList = FXCollections.observableArrayList(authors);
			 tableView.setItems(observableList);
		 }
		
	}
}
