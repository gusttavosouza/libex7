package br.edu.utfpr.adapters.gui.handlers.authors;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		
		try {
			TextField txtName = view.getTxtName();
			 String name = txtName.getText();
			 
			 if(!StringUtils.isEmpty(name)) {
				 List<Author> authors = useCase.findByName(name.toUpperCase().trim());
			     TableView<Author> tableView = view.getTableView();
				 ObservableList<Author> observableList = FXCollections.observableArrayList(authors);
				 tableView.setItems(observableList);
			 }else {
				 List<Author> authors = useCase.findAll();
				 TableView<Author> tableView = view.getTableView();
				 ObservableList<Author> observableList = FXCollections.observableArrayList(authors);
				 tableView.setItems(observableList);
			 }
		}catch (Exception e) {
		  e.printStackTrace();
		  Alert alert = new Alert(AlertType.ERROR, "Erro ao consultar author");
		  alert.setContentText(e.getMessage());
		  alert.show();
		}
		
		 
		
	}
}
