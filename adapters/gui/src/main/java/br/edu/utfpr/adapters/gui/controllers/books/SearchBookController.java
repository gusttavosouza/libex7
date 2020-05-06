package br.edu.utfpr.adapters.gui.controllers.books;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.edu.utfpr.adapters.gui.views.books.SearchBookView;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
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
			 TextField txtAuthorName = view.getTxtAuthorName();
			 
			 String title = txtTitle.getText();
			 String authorName = txtAuthorName.getText();
			 
			 if(StringUtils.isEmpty(title)) {
				 List<Book> books = useCase.findByTitle(title);
				 TableView<Book> tableView = view.getTableView();
				 ObservableList<Book> observableList = FXCollections.observableArrayList(books);
				 tableView.setItems(observableList);
			 }else if(!StringUtils.isEmpty(authorName)) {
				 List<Book> books = useCase.findByAuthorName(authorName);
				 TableView<Book> tableView = view.getTableView();
				 ObservableList<Book> observableList = FXCollections.observableArrayList(books);
				 tableView.setItems(observableList);
			 }else {
				 List<Book> books = useCase.findAll();
				 TableView<Book> tableView = view.getTableView();
				 ObservableList<Book> observableList = FXCollections.observableArrayList(books);
				 tableView.setItems(observableList); 
			 }
			
		}
	});
		
	}

}
