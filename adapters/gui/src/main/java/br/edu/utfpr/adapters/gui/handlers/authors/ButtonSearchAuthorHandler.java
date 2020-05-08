package br.edu.utfpr.adapters.gui.handlers.authors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

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
			TextField txtID = view.getTxtID();
			TextField txtName = view.getTxtName();
			
			String id = txtID.getText();
			 String name = txtName.getText();
			 
			 if(!StringUtils.isEmpty(id)) {
				 Optional<Author> optional = useCase.findById(NumberUtils.toLong(id));
				 if(optional.isPresent()) {
					 Author author = optional.get();
					 TableView<Author> tableView = view.getTableView();
					 ObservableList<Author> observableList = FXCollections.observableArrayList(Arrays.asList(author));
					 tableView.setItems(observableList);
				 }
			 }else if(!StringUtils.isEmpty(name)) {
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
