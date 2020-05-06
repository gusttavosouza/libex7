package br.edu.utfpr.adapters.gui.controllers.categories;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.categories.SearchCategoryView;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SearchCategoryController {

	private final SearchCategoryUseCase useCase;
    private final SearchCategoryView view;
    
    
	public SearchCategoryController(SearchCategoryUseCase useCase, SearchCategoryView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			 TextField txtDescription = view.getTxtDescription();
			 String description = txtDescription.getText();
			 
			 if(description != null && !description.isEmpty()) {
				 List<Category> categorys = useCase.findByDescription(description);
				 ListView<Category> listView = view.getListView();
				 ObservableList<Category> observableList = FXCollections.observableArrayList(categorys);
				 listView.setItems(observableList);
			 }
			
		}
	});
		
	}
    
    


}
