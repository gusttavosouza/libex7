package br.edu.utfpr.adapters.gui.handlers.categories;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.categories.SearchCategoryView;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ButtonSearchCategoryHandler implements EventHandler<ActionEvent> {
	

	private final SearchCategoryUseCase useCase;
    private final SearchCategoryView view;
	
    
   
	public ButtonSearchCategoryHandler(SearchCategoryUseCase useCase, SearchCategoryView view) {
		this.useCase = useCase;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		 TextField txtDescription = view.getTxtDescription();
		 String description = txtDescription.getText();
		 
		 if(description != null && !description.isEmpty()) {
			 List<Category> categorys = useCase.findByDescription(description);
			 TableView<Category> tableView = view.getTableView();
			 ObservableList<Category> observableList = FXCollections.observableArrayList(categorys);
			 tableView.setItems(observableList);
		 }else {
			 List<Category> categorys = useCase.findAll();
			 TableView<Category> tableView = view.getTableView();
			 ObservableList<Category> observableList = FXCollections.observableArrayList(categorys);
			 tableView.setItems(observableList);
		 }
		
	}
}