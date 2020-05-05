package br.edu.utfpr.adapters.gui.controllers.books;

import java.util.List;

import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class SearchBookController {

	private final SearchBookUseCase useCase;
    private final SearchBookView view;
    
    
	public SearchBookController(SearchBookUseCase useCase, SearchBookView view) {
		this.useCase = useCase;
		this.view = view;
		init();
	}


	private void init() {
	   Button button = view.getSearchButton();
	   button.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			 TextField txtTitle = view.getTxtTitle();
			 String title = txtTitle.getText();
			 
			 if(title != null && !title.isEmpty()) {
				 List<Book> books = useCase.findByTitle(title);
				 ListView<Book> listView = view.getListView();
				 ObservableList<Book> observableList = FXCollections.observableArrayList(books);
				 listView.setItems(observableList);
			 }
			
		}
	});
		
	}
    
    


}
