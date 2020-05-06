package br.edu.utfpr.adapters.gui.controllers.copies;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.copies.SearchCopyView;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SearchCopyController {

	private final SearchCopyUseCase useCase;
    private final SearchCopyView view;
    
    
	public SearchCopyController(SearchCopyUseCase useCase, SearchCopyView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			 TextField txtTitle = view.getTxtDescription();
			 String title = txtTitle.getText();
			 
			 if(title != null && !title.isEmpty()) {
				 List<Copy> books = useCase.findAll();
				 ListView<Copy> listView = view.getListView();
				 ObservableList<Copy> observableList = FXCollections.observableArrayList(books);
				 listView.setItems(observableList);
			 }
			
		}
	});
		
	}
    
    


}
