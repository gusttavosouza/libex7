package br.edu.utfpr.adapters.gui.controllers.authors;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.authors.SearchAuthorView;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SearchAuthorController {

	private final SearchAuthorUseCase useCase;
    private final SearchAuthorView view;
    
    
	public SearchAuthorController(SearchAuthorUseCase useCase, SearchAuthorView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			 TextField txtName = view.getTxtName();
			 String name = txtName.getText();
			 
			 if(name != null && !name.isEmpty()) {
				 List<Author> authors = useCase.findByName(name);
				 ListView<Author> listView = view.getListView();
				 ObservableList<Author> observableList = FXCollections.observableArrayList(authors);
				 listView.setItems(observableList);
			 }
			
		}
	});
		
	}
    
    


}
